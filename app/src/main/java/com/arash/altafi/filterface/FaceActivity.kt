package com.arash.altafi.filterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.arash.altafi.filterface.databinding.ActivityFaceBinding
import com.google.ar.core.AugmentedFace
import com.google.ar.core.TrackingState
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.Texture
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.AugmentedFaceNode
import java.util.concurrent.CompletableFuture

class FaceActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFaceBinding.inflate(layoutInflater)
    }

    private var faceRenderable: ModelRenderable? = null
    private var faceTexture: Texture? = null
    private val faceNodeMap = HashMap<AugmentedFace, AugmentedFaceNode>()
    private lateinit var arFragment: ArFragment
    private var source: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        source = when (intent.getStringExtra("source")) {
            "sample1" -> R.raw.black
            "sample2" -> R.raw.blue
            "sample3" -> R.raw.blue_sunglasses
            "sample4" -> R.raw.wow
            "sample5" -> R.raw.yellow_sunglasses
            "sample6" -> R.raw.fox_face
            "sample7" -> R.raw.beedrill
            "sample8" -> R.raw.andy
            "sample9" -> R.raw.andymachinery
            "sample10" -> R.raw.chair
            "sample11" -> R.raw.hypno_glasses
            "sample12" -> R.raw.model
            "sample13" -> R.raw.model_fight
            "sample14" -> R.raw.oven
            "sample15" -> R.raw.piano
            "sample16" -> R.raw.plaid
            "sample17" -> R.raw.purple_cat
            "sample18" -> R.raw.red_mask
            "sample19" -> R.raw.rumba
            "sample20" -> R.raw.rumba2
            "sample21" -> R.raw.sunglasses
            "sample22" -> R.raw.table
            "sample23" -> R.raw.tocotoucan
            else -> R.raw.black
        }
        loadModel()

        arFragment = supportFragmentManager.findFragmentById(R.id.face_frag) as ArFragment
        arFragment.arSceneView.cameraStreamRenderPriority = Renderable.RENDER_PRIORITY_FIRST
        arFragment.arSceneView.scene.addOnUpdateListener {
            if (faceRenderable != null && faceTexture != null) {
                addTrackedFaces()
                removeUntrackedFaces()
            }
        }
    }

    private fun loadModel() {
        val modelRenderable = ModelRenderable.builder().setSource(this, source).build()
        val texture = Texture.builder().setSource(this, R.drawable.clown_face_mesh_texture).build()

        CompletableFuture.allOf(modelRenderable, texture).thenAccept {
            faceRenderable = modelRenderable.get().apply {
                isShadowCaster = false
                isShadowReceiver = false
            }
            faceTexture = texture.get()
        }.exceptionally {
            Toast.makeText(this, "Error loading face model : $it", Toast.LENGTH_SHORT).show()
            null
        }
    }

    private fun addTrackedFaces() {
        val session = arFragment.arSceneView.session ?: return
        val faceList = session.getAllTrackables(AugmentedFace::class.java)
        for (face in faceList) {
            if (!faceNodeMap.containsKey(face)) {
                AugmentedFaceNode(face).apply {
                    setParent(arFragment.arSceneView.scene)
                    faceRegionsRenderable = faceRenderable
                    faceMeshTexture = faceTexture
                    faceNodeMap[face] = this
                }
            }
        }
    }

    private fun removeUntrackedFaces() {
        val entries = faceNodeMap.entries
        for (entry in entries) {
            val face = entry.key
            if (face.trackingState == TrackingState.STOPPED) {
                val faceNode = entry.value
                faceNode.setParent(null)
                entries.remove(entry)
            }
        }
    }
}
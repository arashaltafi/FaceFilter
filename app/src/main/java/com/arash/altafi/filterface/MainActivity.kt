package com.arash.altafi.filterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.filterface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() = binding.apply {
        val intent = Intent(this@MainActivity, FaceActivity::class.java)

        btnSample1.setOnClickListener {
            intent.putExtra("source", "sample1")
            startActivity(intent)
        }
        btnSample2.setOnClickListener {
            intent.putExtra("source", "sample2")
            startActivity(intent)
        }
        btnSample3.setOnClickListener {
            intent.putExtra("source", "sample3")
            startActivity(intent)
        }
        btnSample4.setOnClickListener {
            intent.putExtra("source", "sample4")
            startActivity(intent)
        }
        btnSample5.setOnClickListener {
            intent.putExtra("source", "sample5")
            startActivity(intent)
        }
        btnSample6.setOnClickListener {
            intent.putExtra("source", "sample6")
            startActivity(intent)
        }
        btnSample7.setOnClickListener {
            intent.putExtra("source", "sample7")
            startActivity(intent)
        }
        btnSample8.setOnClickListener {
            intent.putExtra("source", "sample8")
            startActivity(intent)
        }
        btnSample9.setOnClickListener {
            intent.putExtra("source", "sample9")
            startActivity(intent)
        }
        btnSample10.setOnClickListener {
            intent.putExtra("source", "sample10")
            startActivity(intent)
        }
        btnSample11.setOnClickListener {
            intent.putExtra("source", "sample11")
            startActivity(intent)
        }
        btnSample12.setOnClickListener {
            intent.putExtra("source", "sample12")
            startActivity(intent)
        }
        btnSample13.setOnClickListener {
            intent.putExtra("source", "sample13")
            startActivity(intent)
        }
        btnSample14.setOnClickListener {
            intent.putExtra("source", "sample14")
            startActivity(intent)
        }
        btnSample15.setOnClickListener {
            intent.putExtra("source", "sample15")
            startActivity(intent)
        }
        btnSample16.setOnClickListener {
            intent.putExtra("source", "sample16")
            startActivity(intent)
        }
        btnSample17.setOnClickListener {
            intent.putExtra("source", "sample17")
            startActivity(intent)
        }
        btnSample18.setOnClickListener {
            intent.putExtra("source", "sample18")
            startActivity(intent)
        }
        btnSample19.setOnClickListener {
            intent.putExtra("source", "sample19")
            startActivity(intent)
        }
        btnSample20.setOnClickListener {
            intent.putExtra("source", "sample20")
            startActivity(intent)
        }
        btnSample21.setOnClickListener {
            intent.putExtra("source", "sample21")
            startActivity(intent)
        }
        btnSample22.setOnClickListener {
            intent.putExtra("source", "sample22")
            startActivity(intent)
        }
        btnSample23.setOnClickListener {
            intent.putExtra("source", "sample23")
            startActivity(intent)
        }
    }
}
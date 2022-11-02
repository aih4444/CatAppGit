package com.example.catapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catapp.databinding.ActivityMainLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
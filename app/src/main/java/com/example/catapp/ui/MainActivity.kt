package com.example.catapp.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.catapp.R
import com.example.catapp.databinding.ActivityMainLayoutBinding
import com.example.catapp.ui.breeds.BreedListFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package com.example.catapp.ui.breeds

import com.example.catapp.network.CatApiService

class Repository(private val apiService: CatApiService) {

    suspend fun getAllBreeds() = apiService.getAllBreeds()

}
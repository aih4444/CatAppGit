package com.example.catapp.network

import com.example.catapp.model.CatBreed
import com.example.catapp.model.DogBreed
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET(DOG_API.API_BREEDLIST)
    suspend fun getAllBreeds(): Response<List<DogBreed>>
}
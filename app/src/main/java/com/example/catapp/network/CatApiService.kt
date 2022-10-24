package com.example.catapp.network

import com.example.catapp.model.CatBreed
import retrofit2.Response
import retrofit2.http.GET

interface CatApiService {

    @GET(REST_API.API_BREEDLIST)
    suspend fun getAllBreeds(): Response<List<CatBreed>>
}
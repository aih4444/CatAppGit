package com.example.catapp.di

import com.example.catapp.network.CatApiService
import com.example.catapp.network.REST_API
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { createService(get()) }

}
fun createService(retrofit: Retrofit): CatApiService =
    retrofit.create(CatApiService::class.java)

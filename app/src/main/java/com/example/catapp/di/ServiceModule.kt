package com.example.catapp.di

import com.example.catapp.network.CatApiService
import com.example.catapp.network.DogApiService
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { createService(get(named("cat"))) }
    single { createDogService(get(named("dog"))) }

}
fun createService(retrofit: Retrofit): CatApiService =
    retrofit.create(CatApiService::class.java)


fun createDogService(retrofit: Retrofit): DogApiService =
    retrofit.create(DogApiService::class.java)


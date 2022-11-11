package com.example.catapp.di

import com.example.catapp.network.DOG_API
import com.example.catapp.network.REST_API
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single(named("cat")) { Retrofit.Builder().baseUrl(REST_API.API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }
    single(named("dog")) { Retrofit.Builder().baseUrl(DOG_API.API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }
}

package com.example.catapp.di

import com.example.catapp.network.REST_API
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    single { Retrofit.Builder().baseUrl(REST_API.API_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build() }
}

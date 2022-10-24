package com.example.catapp

import android.app.Application
import com.example.catapp.di.retrofitModule
import com.example.catapp.di.serviceModule
import com.example.catapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(listOf(retrofitModule, viewModelModule, serviceModule ))
        }
    }
}
package com.example.catapp.di

import com.example.catapp.ui.breeds.Repository
import org.koin.dsl.module

val repositoryModule = module { single { Repository(get()) } }

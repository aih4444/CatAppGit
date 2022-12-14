package com.example.catapp.di

import com.example.catapp.ui.breeds.BreedListViewModel
import com.example.catapp.ui.dogs.DogsListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BreedListViewModel(androidApplication(), get()) }
    viewModel { DogsListViewModel(get()) }
}
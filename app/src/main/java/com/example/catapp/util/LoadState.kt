package com.example.catapp.util

import com.example.catapp.model.CatBreed

sealed class LoadState{
    object Loading: LoadState()
    data class Error<E>(val error: E): LoadState()
    data class Success<T>(val response: List<CatBreed>?): LoadState()
}

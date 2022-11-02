package com.example.catapp.ui.breeds

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.catapp.model.CatBreed
import com.example.catapp.network.CatApiService
import com.example.catapp.util.LoadState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreedListViewModel(application: Application, val repository: Repository) :
    AndroidViewModel(application) {

    private val _listOfBreeds =  MutableLiveData<LoadState>()
     val listOfBreeds: LiveData<LoadState>  = _listOfBreeds

    fun updateList() {
        _listOfBreeds.postValue(LoadState.Loading)
        CoroutineScope(Dispatchers.Main).launch {
            val response = repository.getAllBreeds()

            if (response.isSuccessful) {
                _listOfBreeds.postValue(LoadState.Success<List<CatBreed>>(response.body()))
            }
            else{
                _listOfBreeds.postValue(LoadState.Error(response.errorBody()))
            }
        }
    }
}
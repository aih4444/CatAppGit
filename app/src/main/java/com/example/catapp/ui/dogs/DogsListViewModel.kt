package com.example.catapp.ui.dogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catapp.model.DogBreed
import com.example.catapp.network.DogApiService
import com.example.catapp.util.LoadState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogsListViewModel(val apiService: DogApiService) : ViewModel() {

    private val _listOfBreeds =  MutableLiveData<LoadState>()
    val listOfBreeds: LiveData<LoadState> = _listOfBreeds

    fun updateList() {
        _listOfBreeds.postValue(LoadState.Loading)
        CoroutineScope(Dispatchers.Main).launch {
            val response = apiService.getAllBreeds()

            if (response.isSuccessful) {
                _listOfBreeds.postValue(LoadState.Success<List<DogBreed>>(response.body()))
            }
            else{
                _listOfBreeds.postValue(LoadState.Error(response.errorBody()))
            }
        }
    }

}
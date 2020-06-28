package com.example.binarapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.binarapp.Model.GenresResponse
import com.example.binarapp.Network.MainRepository

class MainViewModel (application: Application): AndroidViewModel(application) {
    private val repository = MainRepository()

    var genres : MutableLiveData<GenresResponse> = MutableLiveData()
//    var movies : MutableLiveData<MovieResponse> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getGenre(){
        repository.requestGenre({
            genres.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}
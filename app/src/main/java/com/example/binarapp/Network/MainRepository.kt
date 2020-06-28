package com.example.binarapp.Network

import com.example.binarapp.Model.GenresResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {

    private val apiService = GenresRepository.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestGenre(onResult: (GenresResponse) -> Unit, onError: (Throwable) -> Unit){
        apiService.getGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: ApiObserver<GenresResponse>(compositeDisposable){
                override fun onApiSuccess(data: GenresResponse) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}




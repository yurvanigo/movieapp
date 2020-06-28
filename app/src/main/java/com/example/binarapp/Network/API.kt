package com.example.binarapp.Network

import com.example.binarapp.Model.GenresResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface API{
    @GET("321612?api_key=e458ef52807d114d92f614b11735092d")
    fun getGenre(): Observable<GenresResponse>
}
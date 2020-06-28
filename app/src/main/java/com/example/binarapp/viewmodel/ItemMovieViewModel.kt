package com.example.binarapp.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.binarapp.Model.Genre

class ItemMovieViewModel(model: Genre): ViewModel() {
    var name: ObservableField<String> = ObservableField()
    var overview: ObservableField<String> = ObservableField()
    var poster: ObservableField<String> = ObservableField()
    var date: ObservableField<String> = ObservableField()

    init {
        name.set(model.genres)
//        overview.set(model.overview)
//        poster.set(model.poster_path)
//        date.set(model.release_date)
    }

}
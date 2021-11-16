package com.gmail.devpelegrino.moplim.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gmail.devpelegrino.moplim.model.Movie

class ItemMovieListViewModel: ViewModel() {

    private var _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie>
        get() = _movie
}
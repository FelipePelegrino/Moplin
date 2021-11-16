package com.gmail.devpelegrino.moplim.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.devpelegrino.moplim.viewmodel.MovieListViewModel

class MovieListViewModelFactory(val app: Application): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieListViewModel::class.java)){
            return MovieListViewModel(app) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}
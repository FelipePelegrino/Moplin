package com.gmail.devpelegrino.moplim.factory

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.devpelegrino.moplim.viewmodel.MovieDetailsViewModel

class MovieDetailsViewModelFactory(val lifecycleOwner: LifecycleOwner): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieDetailsViewModel::class.java)){
            return MovieDetailsViewModel(lifecycleOwner) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}
package com.gmail.devpelegrino.moplim.factory

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.devpelegrino.moplim.viewmodel.MovieListViewModel

class MovieListViewModelFactory(val lifecycleOwner: LifecycleOwner, val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MovieListViewModel::class.java)){
            return MovieListViewModel(lifecycleOwner, context) as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}
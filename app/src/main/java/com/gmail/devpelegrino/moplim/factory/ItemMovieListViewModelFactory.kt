package com.gmail.devpelegrino.moplim.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gmail.devpelegrino.moplim.viewmodel.ItemMovieListViewModel

class ItemMovieListViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ItemMovieListViewModel::class.java)){
            return ItemMovieListViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}
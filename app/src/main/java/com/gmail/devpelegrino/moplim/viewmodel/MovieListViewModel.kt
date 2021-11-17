package com.gmail.devpelegrino.moplim.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.gmail.devpelegrino.moplim.model.Movie
import com.gmail.devpelegrino.moplim.network.ResultApi
import com.gmail.devpelegrino.moplim.repository.FactoryRepository
import com.gmail.devpelegrino.moplim.util.toModel

class MovieListViewModel(private val lifecycleOwner: LifecycleOwner) : ViewModel() {

    private val _repository = FactoryRepository().getRetrofitRepository()

    private var _pageNowPlaying = 1
    private var _moviesNowPlaying = MutableLiveData<MutableList<Movie>>()
    val moviesNowPlaying: LiveData<MutableList<Movie>>
        get() = _moviesNowPlaying

    private var _pagePopular = 1
    private var _moviesPopular = MutableLiveData<MutableList<Movie>>()
    val moviesPopular: LiveData<MutableList<Movie>>
        get() = _moviesPopular

    private var _pageTopRated = 1
    private var _moviesTopRated = MutableLiveData<MutableList<Movie>>()
    val moviesTopRated: LiveData<MutableList<Movie>>
        get() = _moviesTopRated

    private var _pageUpComing = 1
    private var _moviesUpComing = MutableLiveData<MutableList<Movie>>()
    val moviesUpComing: LiveData<MutableList<Movie>>
        get() = _moviesUpComing

    fun callApiGetMoviesNowPlaying(){
        getMoviesNowPlaying()
    }

    private fun getMoviesNowPlaying() {
        var result = _repository.getMoviesNowPlaying(_pageNowPlaying)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                var list: MutableList<Movie> = it.results?.map { it.toModel() }!!
                                    .toMutableList()
                                _moviesNowPlaying.value = list
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar erro
                        }
                    }
                }
            })
    }

    fun updatePageMoviesNowPlaying() {
        _pageNowPlaying++
    }

    fun callApiGetMoviesPopular(){
        getMoviesPopular()
    }

    private fun getMoviesPopular() {
        var result = _repository.getMoviesPopular(_pagePopular)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                var list: MutableList<Movie> = it.results?.map { it.toModel() }!!
                                    .toMutableList()
                                _moviesPopular.value = list
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar erro
                        }
                    }
                }
            })
    }

    fun updatePageMoviesPopular() {
        _pagePopular++
    }

    fun callApiGetMoviesTopRated(){
        getMoviesTopRated()
    }

    private fun getMoviesTopRated() {
        var result = _repository.getMoviesTopRated(_pageNowPlaying)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                var list: MutableList<Movie> = it.results?.map { it.toModel() }!!
                                    .toMutableList()
                                _moviesTopRated.value = list
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar errro
                        }
                    }
                }
            })
    }

    fun updatePageTopRated() {
        _pageTopRated++
    }

    fun callApiGetMoviesUpComing(){
        getMoviesUpComing()
    }

    private fun getMoviesUpComing() {
        var result = _repository.getMoviesUpComing(_pageNowPlaying)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                var list: MutableList<Movie> = it.results?.map { it.toModel() }!!
                                    .toMutableList()
                                _moviesUpComing.value = list
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar errro
                        }
                    }
                }
            })
    }

    fun updatePageMoviesUpComing() {
        _pageUpComing++
    }

}
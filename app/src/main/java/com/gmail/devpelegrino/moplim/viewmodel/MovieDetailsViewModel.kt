package com.gmail.devpelegrino.moplim.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.gmail.devpelegrino.moplim.model.Movie
import com.gmail.devpelegrino.moplim.network.ResultApi
import com.gmail.devpelegrino.moplim.network.entity.DetailsMovieEntity
import com.gmail.devpelegrino.moplim.repository.FactoryRepository
import com.gmail.devpelegrino.moplim.util.toModel

class MovieDetailsViewModel(private val lifecycleOwner: LifecycleOwner) : ViewModel() {

    private val _repository = FactoryRepository().getRetrofitRepository()

    private var _pageSimilarMovies = 1
    private var _similarMovies = MutableLiveData<MutableList<Movie>>()
    val similarMovies: LiveData<MutableList<Movie>>
        get() = _similarMovies

    private var _detailsMovie = MutableLiveData<DetailsMovieEntity>()
    val detailsMovie: LiveData<DetailsMovieEntity>
        get() = _detailsMovie

    fun callApiGetSimilarMovies(movieId: Int){
        getSimilarMovies(movieId)
    }

    private fun getSimilarMovies(movieId: Int) {
        var result = _repository.getSimilarMovies(movieId, _pageSimilarMovies)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                var list: MutableList<Movie> = it.results?.map { it.toModel() }!!
                                    .toMutableList()
                                _similarMovies.value = list
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar erro
                        }
                    }
                }
            })
    }

    fun updatePageSimilarMovies() {
        _pageSimilarMovies++
    }

    fun callApiGetDetailsMovie(movieId: Int){
        getDetailsMovie(movieId)
    }

    private fun getDetailsMovie(movieId: Int) {
        var result = _repository.getDetailsMovie(movieId)
        result.observe(lifecycleOwner,
            Observer {
                it?.let { resultApi ->
                    when (resultApi) {
                        is ResultApi.Success -> {
                            resultApi.data?.let { it ->
                                _detailsMovie.value = it
                            }
                        }
                        is ResultApi.Error -> {
                            //TODO: tratar erro
                        }
                    }
                }
            })
    }
}
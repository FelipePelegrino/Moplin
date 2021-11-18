package com.gmail.devpelegrino.moplim.repository

import androidx.lifecycle.liveData
import com.gmail.devpelegrino.moplim.network.MovieApi
import com.gmail.devpelegrino.moplim.network.ResultApi


class MovieRepository(private val movieApi: MovieApi) {

    fun getMoviesNowPlaying(page: Int) = liveData {
        val result = movieApi.getMoviesNowPlaying(page)
        if(result.isSuccessful){
            emit(ResultApi.Success(data = result.body()))
        } else {
            emit(ResultApi.Error(exception = Exception("Erro ao pesquisar os filmes em exibição")))
        }
    }

    fun getMoviesPopular(page: Int) = liveData {
        val result = movieApi.getMoviesPopular(page)
        if(result.isSuccessful){
            emit(ResultApi.Success(data = result.body()))
        } else {
            emit(ResultApi.Error(exception = Exception("Erro ao pesquisar os filmes mais populares")))
        }
    }

    fun getMoviesTopRated(page: Int) = liveData {
        val result = movieApi.getMoviesTopRated(page)
        if(result.isSuccessful){
            emit(ResultApi.Success(data = result.body()))
        } else {
            emit(ResultApi.Error(exception = Exception("Erro ao pesquisar os filmes melhores avaliados")))
        }
    }

    fun getMoviesUpComing(page: Int) = liveData {
        val result = movieApi.getMoviesUpComing(page)
        if(result.isSuccessful){
            emit(ResultApi.Success(data = result.body()))
        } else {
            emit(ResultApi.Error(exception = Exception("Erro ao pesquisar os filmes em breve")))
        }
    }
}
package com.gmail.devpelegrino.moplim.repository

import com.gmail.devpelegrino.moplim.network.MovieApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactoryRepository {

    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val _movieRepository = MovieRepository(
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    )

    fun getRetrofitRepository(): MovieRepository {
        return _movieRepository
    }
}
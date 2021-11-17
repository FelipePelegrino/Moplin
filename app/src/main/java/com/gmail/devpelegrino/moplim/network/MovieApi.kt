package com.gmail.devpelegrino.moplim.network

import com.gmail.devpelegrino.moplim.network.entity.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieApi {

    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTZkMmNiMzFhNmE4NjNjM2Y5ZDdiNzg2ZDc2YWViMCIsInN1YiI6IjYxOTNlMTY0NDU4MTk5MDA2NGM3NWU1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tq96KbuOXej5v3yvxew2tXSKx0WbmwFH77BO6EK5tYw",
        "Content-Type: application/json;charset=utf-8"
    )
    @GET("movie/now_playing?language=pt-BR&region=BR")
    suspend fun getMoviesNowPlaying(@Query("page") page: Int): Response<MovieList>

    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTZkMmNiMzFhNmE4NjNjM2Y5ZDdiNzg2ZDc2YWViMCIsInN1YiI6IjYxOTNlMTY0NDU4MTk5MDA2NGM3NWU1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tq96KbuOXej5v3yvxew2tXSKx0WbmwFH77BO6EK5tYw",
        "Content-Type: application/json;charset=utf-8"
    )
    @GET("movie/top_rated?language=pt-BR&region=BR")
    suspend fun getMoviesTopRated(@Query("page") page: Int): Response<MovieList>

    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTZkMmNiMzFhNmE4NjNjM2Y5ZDdiNzg2ZDc2YWViMCIsInN1YiI6IjYxOTNlMTY0NDU4MTk5MDA2NGM3NWU1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tq96KbuOXej5v3yvxew2tXSKx0WbmwFH77BO6EK5tYw",
        "Content-Type: application/json;charset=utf-8"
    )
    @GET("movie/upcoming?language=pt-BR&region=BR")
    suspend fun getMoviesUpComing(@Query("page") page: Int): Response<MovieList>

    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1OTZkMmNiMzFhNmE4NjNjM2Y5ZDdiNzg2ZDc2YWViMCIsInN1YiI6IjYxOTNlMTY0NDU4MTk5MDA2NGM3NWU1ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tq96KbuOXej5v3yvxew2tXSKx0WbmwFH77BO6EK5tYw",
        "Content-Type: application/json;charset=utf-8"
    )
    @GET("movie/popular?language=pt-BR&region=BR")
    suspend fun getMoviesPopular(@Query("page") page: Int): Response<MovieList>
}
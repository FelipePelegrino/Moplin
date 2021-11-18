package com.gmail.devpelegrino.moplim.network.entity

import com.google.gson.annotations.SerializedName

data class DetailsMovieEntity(
    @SerializedName("poster_path")
    val poster_path: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("title")
    val title: String?,
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("vote_average")
    val vote_average: Float?,
    @SerializedName("runtime")
    val runtime: Int?
)

data class Genre(
    @SerializedName("name")
    val name: String?
)
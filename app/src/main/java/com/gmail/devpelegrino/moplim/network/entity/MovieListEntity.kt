package com.gmail.devpelegrino.moplim.network.entity

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieItem>?
)

data class MovieItem(
    @SerializedName("poster_path")
    val poster_path: String?,
    @SerializedName("id")
    val id: Int?
)
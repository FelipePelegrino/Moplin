package com.gmail.devpelegrino.moplim.util

fun com.gmail.devpelegrino.moplim.network.entity.MovieItem.toModel() = com.gmail.devpelegrino.moplim.model.Movie (
    id = id,
    posterPath = poster_path
)
package com.zaryabshakir.movieapplicationjetpackcompose.network.responses

import com.google.gson.annotations.SerializedName
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.MovieDto


data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieDto>
)
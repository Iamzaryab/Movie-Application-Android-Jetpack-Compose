package com.zaryabshakir.movieapplicationjetpackcompose.network.responses

import com.google.gson.annotations.SerializedName
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.GenreDto


data class GenresResponse(
    @SerializedName("genres")
    val genres: List<GenreDto>
)
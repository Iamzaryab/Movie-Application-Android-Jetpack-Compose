package com.zaryabshakir.movieapplicationjetpackcompose.network.model

import com.google.gson.annotations.SerializedName

data class ProductionCountriesDto(
    @SerializedName("iso_3166_1")
    val iso_3166_1: String,
    @SerializedName("name")
    val name: String
)
package com.zaryabshakir.movieapplicationjetpackcompose.network.model

import com.google.gson.annotations.SerializedName

data class BelongToCollectionDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("backdrop_path")
    val backdrop_path: String
)
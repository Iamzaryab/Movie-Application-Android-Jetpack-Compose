package com.zaryabshakir.movieapplicationjetpackcompose.network.model

import com.google.gson.annotations.SerializedName

data class CastDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("original_name")
    val original_name: String,
    @SerializedName("profile_path")
    val profile_path: String?
)

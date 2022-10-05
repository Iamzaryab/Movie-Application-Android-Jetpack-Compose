package com.zaryabshakir.movieapplicationjetpackcompose.network.responses

import com.google.gson.annotations.SerializedName
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.CastDto

data class CastsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("cast")
    val cast: List<CastDto>
)
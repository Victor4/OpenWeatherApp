package com.victor.data.model.remote.model

import com.google.gson.annotations.SerializedName

data class CoordInfo(
    @SerializedName("log")
    val log : Double,
    @SerializedName("lat")
    val lat : Double
)
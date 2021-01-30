package com.victor.desafio_box.model

import com.google.gson.annotations.SerializedName

data class CoordInfo(
    @SerializedName("log")
    val log : Double,
    @SerializedName("lat")
    val lat : Double
)
package com.victor.desafio_box.model

import com.google.gson.annotations.SerializedName

data class WindInfo(
    @SerializedName("speed")
    val speed : Double,
    @SerializedName("deg")
    val deg : Int
)
package com.victor.data.model.remote.model

import com.google.gson.annotations.SerializedName

data class WindInfo(
    @SerializedName("speed")
    val speed : Double,
    @SerializedName("deg")
    val deg : Int
)
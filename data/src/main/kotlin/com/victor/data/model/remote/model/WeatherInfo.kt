package com.victor.data.model.remote.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("id")
    val id : Int,
    @SerializedName("main")
    val main : String,
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon : String
)
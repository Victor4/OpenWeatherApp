package com.victor.desafio_box.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord")
    val coord : CoordInfo,
    @SerializedName("weather")
    val weatherInfo: List<WeatherInfo>,
    @SerializedName("base")
    val base : String,
    @SerializedName("main")
    val main : MainInfo,
    @SerializedName("visibility")
    val visibility : Int,
    @SerializedName("wind")
    val windInfo : WindInfo,
    @SerializedName("clouds")
    val cloudsInfo : CloudsInfo,
    @SerializedName("all")
    val all : Int,
    @SerializedName("dt")
    val dt : Int,
    @SerializedName("sys")
    val sys : SysInfo,
    @SerializedName("timezone")
    val timezone : Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("cod")
    val cod : Int
)











package com.victor.data.model.remote.model

import com.google.gson.annotations.SerializedName

data class SysInfo(
    @SerializedName("type")
    val type : Int,
    @SerializedName("id")
    val id : Int,
    @SerializedName("message")
    val message : Double,
    @SerializedName("country")
    val country : String,
    @SerializedName("sunrise")
    val sunrise : Int,
    @SerializedName("sunset")
    val sunset : Int
)
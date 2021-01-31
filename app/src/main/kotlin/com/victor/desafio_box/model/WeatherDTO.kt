package com.victor.desafio_box.model

import java.util.Date

data class WeatherDTO(
    val weather : String,
    val temp : String,
    val minTemp : String,
    val maxTemp : String,
    val humidity : String,
    val pressure : String,
    val wind : String,
    val sunrise : Date,
    val sunset : Date,
    val dayTime: Date,
    val cityCountry : String
)

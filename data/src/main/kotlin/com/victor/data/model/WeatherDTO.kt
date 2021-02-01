package com.victor.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "weather_table")
data class WeatherDTO(
    @PrimaryKey(autoGenerate = false)
    val city : String,
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

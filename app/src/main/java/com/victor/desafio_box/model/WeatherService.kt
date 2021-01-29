package com.victor.desafio_box.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {
    @GET("data/2.5/weather")
    fun weatherDataCity(
        @Query("q") city : String,
        @Query("appid") openWeatherKey : String
    ) : Call<WeatherResponse>
}
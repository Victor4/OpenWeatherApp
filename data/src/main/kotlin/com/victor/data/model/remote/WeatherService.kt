package com.victor.data.model.remote

import com.victor.data.model.remote.model.WeatherResponse
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
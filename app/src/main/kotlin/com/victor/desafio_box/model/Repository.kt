package com.victor.desafio_box.model

import com.victor.desafio_box.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository() {

    suspend  fun getWeatherFrom(city: String): Response<WeatherResponse> {
        return withContext(Dispatchers.Default) {
            RetrofitBuilder.weatherService.weatherDataCity(city, BuildConfig.OPENWEATHER_KEY)
        }.execute()
    }
}
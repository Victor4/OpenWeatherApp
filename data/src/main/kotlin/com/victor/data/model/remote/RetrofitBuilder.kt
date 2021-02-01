package com.victor.data.model.remote

import com.victor.data.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.OPENWEATHER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherService : WeatherService = getRetrofit().create(WeatherService::class.java)
}
package com.victor.desafio_box.model

import com.victor.desafio_box.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun builderClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.OPENWEATHER_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
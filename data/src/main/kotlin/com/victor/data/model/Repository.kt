package com.victor.data.model

import androidx.lifecycle.LiveData
import com.victor.data.BuildConfig
import com.victor.data.model.local.WeatherDao
import com.victor.data.model.remote.RetrofitBuilder
import com.victor.data.model.remote.model.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository() {

    inner class Remote {
        suspend fun getWeatherFrom(city: String): Response<WeatherResponse> {
            return withContext(Dispatchers.Default) {
                RetrofitBuilder.weatherService.weatherDataCity(city, BuildConfig.OPENWEATHER_KEY)
            }.execute()
        }
    }

    inner class Local(private val weatherDao: WeatherDao) {
            val readAllWeather : LiveData<List<WeatherDTO>> = weatherDao.readAllWeather()

            suspend fun addWeather(weatherDTO: WeatherDTO){
                weatherDao.addWeather(weatherDTO)
            }
    }
}
package com.victor.data.model.local

import androidx.lifecycle.LiveData
import com.victor.data.model.WeatherDTO

class WeatherRepository(private val weatherDao: WeatherDao) {

    val readAllWeather : LiveData<List<WeatherDTO>> = weatherDao.readAllWeather()

    suspend fun addWeather(weatherDTO: WeatherDTO){
        weatherDao.addWeather(weatherDTO)
    }
}
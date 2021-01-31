package com.victor.desafio_box.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.victor.desafio_box.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.Date

class HomeViewModel : ViewModel() {

    private val KELVIN_CONVERT = 273.15
    private val CELSIUS = "°C"
    private val PRESSURE_SUFIX = "mBar"
    private val WIND_SUFIX = "km/h"
    private val PORCENT = "%"
    val repository: Repository = Repository()
    val weatherDTO = MutableLiveData<WeatherDTO>()

    fun getWeatherFrom(city: String) {
        try {
            CoroutineScope(Dispatchers.Main).launch {
                weatherDTO.value = processInformation(
                    withContext(Dispatchers.Default) {
                        repository.getWeatherFrom(city)
                    }.body() as WeatherResponse, city
                )
            }
        }catch (e : Exception){
            weatherDTO.value = null
        }
    }

    private fun processInformation(weatherInfo: WeatherResponse, city: String): WeatherDTO? {

        return weatherInfo?.let {
            WeatherDTO(
                weather = weatherInfo.weatherInfo[0].main,
                temp = kelvinToCelsius(weatherInfo.main.temp),
                minTemp = kelvinToCelsius(weatherInfo.main.temp_min).plus(CELSIUS),
                maxTemp = kelvinToCelsius(weatherInfo.main.temp_max).plus(CELSIUS),
                humidity = weatherInfo.main.humidity.toString().plus(PORCENT),
                pressure = weatherInfo.main.pressure.toString().plus(PRESSURE_SUFIX),
                wind = weatherInfo.windInfo.speed.toString().plus(WIND_SUFIX),
                sunrise = getDateTimeFromEpocLongOfSeconds(
                    weatherInfo.sys.sunrise,
                    weatherInfo.timezone
                ),
                sunset = getDateTimeFromEpocLongOfSeconds(
                    weatherInfo.sys.sunset,
                    weatherInfo.timezone
                ),
                dayTime = getDateTimeFromEpocLongOfSeconds(
                    weatherInfo.dt,
                    weatherInfo.timezone
                ),
                cityCountry = city.plus(", ").plus(weatherInfo.sys.country)
            )
        }
    }

    private fun kelvinToCelsius(temp: Double): String {
        return String.format("%.0f", temp - KELVIN_CONVERT)
    }

    private fun getDateTimeFromEpocLongOfSeconds(epoc: Int, timeZoneShift: Int): Date {
        try {
            return Date((epoc.toLong() + timeZoneShift) * 1000)
        } catch (e: Exception) {
            e.toString()
            return Date()
        }
    }
}
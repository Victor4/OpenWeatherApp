package com.victor.weather.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victor.data.model.*
import com.victor.data.model.local.WeatherDao
import com.victor.data.model.local.WeatherDatabase
import com.victor.data.model.remote.Repository
import com.victor.data.model.remote.model.WeatherResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.*

class HomeViewModel(context: Context) : ViewModel() {

    private val KELVIN_CONVERT = 273.15
    private val CELSIUS = "°C"
    private val PRESSURE_SUFIX = "mBar"
    private val WIND_SUFIX = "km/h"
    private val PORCENT = "%"

    private val weatherRepository: Repository = Repository()
    private val weatherDao: WeatherDao
    val readAllWeather: LiveData<List<WeatherDTO>>
    val readWeather = MutableLiveData<WeatherDTO>()
    val weatherDTO = MutableLiveData<WeatherDTO>()
    val error = MutableLiveData<Boolean>()

    init {
        weatherDao = WeatherDatabase.getDatabase(context).weatherDao()
        readAllWeather = weatherRepository.Local(weatherDao).readAllWeather
    }

    fun addWeather(weatherDTO: WeatherDTO) {
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.Local(weatherDao).addWeather(weatherDTO)
        }
    }

    fun getWeatherFrom(city: String) {

        try {
            CoroutineScope(Dispatchers.Main).launch {
                weatherDTO.value =
                    withContext(Dispatchers.Default) {
                        val response = weatherRepository.Remote().getWeatherFrom(city).body()
                        if (response != null) {
                            processInformation(response, city)
                        }else{
                            error.postValue(true)
                            null
                        }
                    }
            }
        } catch (e: Exception) {
            error.postValue(true)
            weatherDTO.value = null
        }
    }

    private fun processInformation(weatherInfo: WeatherResponse, city: String): WeatherDTO? {

        weatherInfo?.let {
            val weatherDTO = WeatherDTO(
                city = city,
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
            addWeather(weatherDTO)
            return weatherDTO
        }

    }

    private fun kelvinToCelsius(temp: Double): String {
        return String.format("%.0f", temp - KELVIN_CONVERT)
    }

    private fun getDateTimeFromEpocLongOfSeconds(epoc: Int, timeZoneShift: Int): Date {
        return try {
            Date((epoc.toLong() + timeZoneShift) * 1000)
        } catch (e: Exception) {
            e.toString()
            Date()
        }
    }


}
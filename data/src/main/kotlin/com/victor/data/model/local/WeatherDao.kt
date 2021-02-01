package com.victor.data.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.victor.data.model.WeatherDTO

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeather(weatherDTO: WeatherDTO)

    @Query("SELECT * FROM weather_table ORDER BY city ASC")
    fun readAllWeather() :  LiveData<List<WeatherDTO>>

    @Query("SELECT * FROM weather_table WHERE city LIKE :citySearch")
    fun readWeatherFromCity(citySearch : String? = "") : LiveData<WeatherDTO>

}
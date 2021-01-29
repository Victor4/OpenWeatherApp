package com.victor.desafio_box

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.victor.desafio_box.model.RetrofitClient
import com.victor.desafio_box.model.WeatherResponse
import com.victor.desafio_box.model.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivityViewModel : ViewModel() {

    val weather = MutableLiveData<WeatherResponse>()

    fun search(){
        try {
            val a = RetrofitClient().builderClient().create(WeatherService::class.java)
                .weatherDataCity("porto,alegre", BuildConfig.OPENWEATHER_KEY)
            a.enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    weather.postValue(response.body() as WeatherResponse)
                    //val c = weather.value.weatherInfo.get(0).description

                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        } catch (e: Exception) {
            System.out.println(e)
        }

    }
}
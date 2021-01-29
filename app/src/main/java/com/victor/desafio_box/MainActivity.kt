package com.victor.desafio_box

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.victor.desafio_box.databinding.ActivityMainBinding
import com.victor.desafio_box.model.WeatherResponse


class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        //val view : View = activityBinding.root
        setContentView(activityBinding.root)

        viewModel = ViewModelProvider(this,MainViewModelFactory()).get(MainActivityViewModel::class.java)
        viewModel.search()

        prepareUi()

    }


    private fun prepareUi() {

        val text : TextView = findViewById(R.id.dateAndTimeTextView)
        //text.text = "hoje"
        viewModel.weather.observe(this, Observer { weatherInfo ->
            System.out.println(weatherInfo)
            activityBinding.firstColumnLayout.weatherImageView.setImageDrawable(getDrawable(R.drawable.ic_sunny_day))
            activityBinding.firstColumnLayout.weatherTextView.text = weatherInfo.weatherInfo[0].main
            activityBinding.firstColumnLayout.humidityTextView.text = weatherInfo.main.humidity.toString()+"%"

            activityBinding.secondColumnLayout.tempTextView.text = String.format("%.0f", weatherInfo.main.temp - 273.15)
            activityBinding.secondColumnLayout.pressureTextView.text = weatherInfo.main.pressure.toString()+"mBar"

            activityBinding.thirdColumnLayout.maxTempTextView.text = String.format("%.0f", weatherInfo.main.temp_max - 273.15)+"°C"
            activityBinding.thirdColumnLayout.minTempTextView.text = String.format("%.0f", weatherInfo.main.temp_min - 273.15)+"°C"
            activityBinding.thirdColumnLayout.windTextView.text = weatherInfo.windInfo.speed.toString()+"km/h"

        })

    }

    class MainViewModelFactory() : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainActivityViewModel() as T
        }

    }


}


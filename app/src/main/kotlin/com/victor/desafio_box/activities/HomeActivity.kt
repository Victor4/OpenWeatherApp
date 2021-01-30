package com.victor.desafio_box.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.victor.desafio_box.R
import com.victor.desafio_box.databinding.ActivityHomeBinding
import com.victor.desafio_box.model.WeatherResponse
import com.victor.desafio_box.viewModel.HomeViewModel
import com.victor.desafio_box.viewModel.ViewModelFactory
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    private lateinit var viewModel: HomeViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(HomeViewModel::class.java)
        viewModel.search()
        prepareUi()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun prepareUi() {

        viewModel.weather.observe(this, Observer { weatherInfo ->
            val date = LocalDateTime.now()

            System.out.println(date.dayOfWeek.toString() + ", " + date.dayOfMonth + " " + date.month + " " + date.year + " | " + date.hour + ":" + date.minute)
            System.out.println(weatherInfo)
            with(activityHomeBinding) {
                dateAndTimeTextView.text = date.dayOfWeek.toString()
                    .toLowerCase() + ", " + date.dayOfMonth + " " + date.month.toString()
                    .toLowerCase() + " " + date.year + " | " + date.hour + ":" + date.minute

                tempEmptySearchLinearLayout.visibility = View.GONE
                tempInfoLinearLayout.visibility = View.VISIBLE
                dateAndcityInfoConstraintLayout.visibility = View.VISIBLE

                fillFirstColumnData(weatherInfo)
                fillSecondColumnData(weatherInfo)
                fillThirdColumnData(weatherInfo)
            }
        })

    }

    private fun fillFirstColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            firstColumnLayout.weatherImageView.setImageDrawable(
                getDrawable(
                    R.drawable.ic_sunny_day
                )
            )
            firstColumnLayout.weatherTextView.text =
                weatherInfo.weatherInfo[0].main
            firstColumnLayout.humidityTextView.text =
                weatherInfo.main.humidity.toString() + "%"

            var dateFormatter = SimpleDateFormat("HH:mm:ss")
            dateFormatter.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
            firstColumnLayout.sunriseTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunrise))
        }
    }

    private fun fillSecondColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            secondColumnLayout.tempTextView.text =
                String.format("%.0f", weatherInfo.main.temp - 273.15)
            secondColumnLayout.pressureTextView.text =
                weatherInfo.main.pressure.toString() + "mBar"
            var dateFormatter = SimpleDateFormat("HH:mm:ss")
            dateFormatter.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
            secondColumnLayout.sunsetTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunset))
        }
    }

    private fun fillThirdColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            var dateFormatter = SimpleDateFormat("HH:mm:ss")
            dateFormatter.timeZone = TimeZone.getTimeZone("America/Sao_Paulo")
            thirdColumnLayout.maxTempTextView.text =
                String.format("%.0f", weatherInfo.main.temp_max - 273.15) + "°C"
            thirdColumnLayout.minTempTextView.text =
                String.format("%.0f", weatherInfo.main.temp_min - 273.15) + "°C"
            thirdColumnLayout.windTextView.text =
                weatherInfo.windInfo.speed.toString() + "km/h"
            thirdColumnLayout.daytimeTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.dt))
        }
    }

    private fun getDateTimeFromEpocLongOfSeconds(epoc: Int): Date? {
        try {
            var tz = TimeZone.getTimeZone("America/Sao_Paulo");
            return Date(epoc.toLong() * 1000)
        } catch (e: Exception) {
            e.toString()
            return null
        }
    }

}
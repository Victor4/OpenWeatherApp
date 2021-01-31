package com.victor.desafio_box.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.victor.desafio_box.R
import com.victor.desafio_box.databinding.ActivityHomeBinding
import com.victor.desafio_box.viewModel.HomeViewModel
import com.victor.desafio_box.viewModel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    private lateinit var viewModel: HomeViewModel

    private val city = "canoas"

    var dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(HomeViewModel::class.java)
        viewModel.getWeatherFrom(city)
        prepareUi()
    }

    private fun prepareUi() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))

        viewModel.weatherDTO.observe(this, Observer { weatherInfo ->
            with(activityHomeBinding) {
                dateAndTimeTextView.text = weatherInfo.dayTime.toString()

                verifiDayOrNight(weatherInfo.dayTime, weatherInfo.sunrise, weatherInfo.sunset)

                tempEmptySearchLinearLayout.visibility = View.GONE
                tempInfoLinearLayout.visibility = View.VISIBLE
                dateAndcityInfoConstraintLayout.visibility = View.VISIBLE

                locationTextView.text = weatherInfo.cityCountry
                fillFirstColumnData(weatherInfo.weather, weatherInfo.humidity, weatherInfo.sunrise)
                fillSecondColumnData(weatherInfo.temp, weatherInfo.pressure, weatherInfo.sunset)
                fillThirdColumnData(weatherInfo.maxTemp, weatherInfo.minTemp, weatherInfo.wind, weatherInfo.dayTime)
            }
        })

    }

    private fun fillFirstColumnData(weather: String, humidity: String, sunriseDate: Date) {
        with(activityHomeBinding) {
            firstColumnLayout.weatherImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    this@HomeActivity,
                    R.drawable.ic_sunny_day
                )
            )
            firstColumnLayout.weatherTextView.text = weather
            firstColumnLayout.humidityTextView.text = humidity
            firstColumnLayout.sunriseTextView.text =
                dateFormatter.format(sunriseDate)
        }
    }

    private fun fillSecondColumnData(temp: String, pressure: String, sunsetDate: Date) {
        with(activityHomeBinding) {
            secondColumnLayout.tempTextView.text = temp
            secondColumnLayout.pressureTextView.text = pressure

            secondColumnLayout.sunsetTextView.text =
                dateFormatter.format(sunsetDate)
        }
    }

    private fun fillThirdColumnData(maxTemp: String, minTemp: String, wind: String, dateNow: Date) {
        with(activityHomeBinding) {
            thirdColumnLayout.maxTempTextView.text = maxTemp
            thirdColumnLayout.minTempTextView.text = minTemp
            thirdColumnLayout.windTextView.text = wind
            thirdColumnLayout.daytimeTextView.text =
                dateFormatter.format(dateNow)
        }
    }


    private fun verifiDayOrNight(dateNow: Date, sunriseDate: Date, sunsetDate: Date) {
        if (dateNow.after(sunriseDate) && dateNow.before(sunsetDate)) {
            activityHomeBinding.wallpaperImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    this@HomeActivity,
                    R.drawable.ic_day_image
                )
            )
        } else {
            activityHomeBinding.wallpaperImageView.setImageDrawable(
                ContextCompat.getDrawable(
                    this@HomeActivity,
                    R.drawable.ic_night_image
                )
            )
        }

    }

}
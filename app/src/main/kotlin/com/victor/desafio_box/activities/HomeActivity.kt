package com.victor.desafio_box.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.victor.desafio_box.R
import com.victor.desafio_box.databinding.ActivityHomeBinding
import com.victor.desafio_box.model.WeatherResponse
import com.victor.desafio_box.viewModel.HomeViewModel
import com.victor.desafio_box.viewModel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    private lateinit var viewModel: HomeViewModel
    private val KELVIN_CONVERT = 273.15
    private val city = "Canoas"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(HomeViewModel::class.java)
        viewModel.search(city)
        prepareUi()
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun prepareUi() {

        viewModel.weather.observe(this, Observer { weatherInfo ->
            with(activityHomeBinding) {
                dateAndTimeTextView.text = getDateTimeFromEpocLongOfSeconds(weatherInfo.dt,weatherInfo.timezone).toString()

                verifiDayOrNight(weatherInfo.dt, weatherInfo.sys.sunrise, weatherInfo.sys.sunset)

                tempEmptySearchLinearLayout.visibility = View.GONE
                tempInfoLinearLayout.visibility = View.VISIBLE
                dateAndcityInfoConstraintLayout.visibility = View.VISIBLE

                locationTextView.text = city.plus(", ").plus(weatherInfo.sys.country)
                System.out.println(weatherInfo)
                fillFirstColumnData(weatherInfo)
                fillSecondColumnData(weatherInfo)
                fillThirdColumnData(weatherInfo)
            }
        })

    }

    private fun fillFirstColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            firstColumnLayout.weatherImageView.setImageDrawable(
                ContextCompat.getDrawable(this@HomeActivity,
                    R.drawable.ic_sunny_day
                )
            )
            firstColumnLayout.weatherTextView.text =
                weatherInfo.weatherInfo[0].main
            firstColumnLayout.humidityTextView.text =
                weatherInfo.main.humidity.toString().plus("%")

            var dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            firstColumnLayout.sunriseTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunrise,weatherInfo.timezone))
            System.out.println("sunrise"+getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunrise,weatherInfo.timezone))
        }
    }

    private fun fillSecondColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            secondColumnLayout.tempTextView.text = kelvinToCelsius(weatherInfo.main.temp)
            secondColumnLayout.pressureTextView.text =
                weatherInfo.main.pressure.toString().plus("mBar")
            var dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            secondColumnLayout.sunsetTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunset,weatherInfo.timezone))
            System.out.println("sunset"+getDateTimeFromEpocLongOfSeconds(weatherInfo.sys.sunset,weatherInfo.timezone))
        }
    }

    private fun fillThirdColumnData(weatherInfo: WeatherResponse) {
        with(activityHomeBinding) {
            val dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            thirdColumnLayout.maxTempTextView.text =
                kelvinToCelsius(weatherInfo.main.temp_max).plus("°C")
            thirdColumnLayout.minTempTextView.text =
                kelvinToCelsius(weatherInfo.main.temp_min).plus("°C")
            thirdColumnLayout.windTextView.text =
                weatherInfo.windInfo.speed.toString().plus("km/h")
            thirdColumnLayout.daytimeTextView.text =
                dateFormatter.format(getDateTimeFromEpocLongOfSeconds(weatherInfo.dt,weatherInfo.timezone))
            System.out.println("daytime"+getDateTimeFromEpocLongOfSeconds(weatherInfo.dt,weatherInfo.timezone))
        }
    }

    private fun getDateTimeFromEpocLongOfSeconds(epoc: Int, timeZoneShift: Int): Date {
        try {
            return Date((epoc.toLong() + timeZoneShift) * 1000 )
        } catch (e: Exception) {
            e.toString()
            return Date()
        }
    }

    private fun kelvinToCelsius(temp : Double) : String{
        return String.format("%.0f", temp - KELVIN_CONVERT)
    }

    private fun verifiDayOrNight(epocNow : Int, epocSunrise: Int, epocSunset: Int){
            val dateNow = Date(epocNow.toLong())
            val sunriseDate = Date(epocSunrise.toLong())
            val sunsetDate = Date(epocSunset.toLong())
            if(dateNow.after(sunriseDate) && dateNow.before(sunsetDate)){
                    activityHomeBinding.wallpaperImageView.setImageDrawable(ContextCompat.getDrawable(this@HomeActivity,
                        R.drawable.ic_day_image
                    ))
            }else{
                activityHomeBinding.wallpaperImageView.setImageDrawable(ContextCompat.getDrawable(this@HomeActivity,
                    R.drawable.ic_night_image
                ))
            }

    }

}
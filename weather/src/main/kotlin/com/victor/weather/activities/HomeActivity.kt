package com.victor.weather.activities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.victor.data.model.WeatherDTO
import com.victor.weather.R
import com.victor.weather.adapters.CityAdapter
import com.victor.weather.databinding.ActivityHomeBinding
import com.victor.weather.viewModel.HomeViewModel
import com.victor.weather.viewModel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class HomeActivity : AppCompatActivity() {
    private lateinit var activityHomeBinding: ActivityHomeBinding

    private lateinit var viewModel: HomeViewModel
    private val TIMEZONE = "UTC"
    private val INICIAL_CITY = "canoas"

    var dateFormatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    var titleDateFormatter = SimpleDateFormat("EEE, d MMM yyyy | HH:mm:ss ", Locale.getDefault())
    var allWeatherDatabse: List<WeatherDTO> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(baseContext)).get(HomeViewModel::class.java)
        dateFormatter.timeZone = TimeZone.getTimeZone(TIMEZONE)
        titleDateFormatter.timeZone = TimeZone.getTimeZone(TIMEZONE)

        prepareListeners()
        loadData(INICIAL_CITY)
    }

    private fun loadData(city: String) {
        if (hasInternet()) {
            viewModel.getWeatherFrom(city)
        } else {
            if (allWeatherDatabse.isNotEmpty()) {
                allWeatherDatabse.map { weather ->
                    if (weather.city == city) {
                        prepareUi(weather)
                    }
                }
            }
        }
    }

    private fun prepareUi(weatherInfo: WeatherDTO) {
        with(activityHomeBinding) {
            dateAndTimeTextView.text = titleDateFormatter.format(weatherInfo.dayTime)

            verifiDayOrNight(weatherInfo.dayTime, weatherInfo.sunrise, weatherInfo.sunset)

            showWeatherDate(true)

            locationTextView.text = weatherInfo.cityCountry
            fillFirstColumnData(
                weatherInfo.weather,
                weatherInfo.humidity,
                weatherInfo.sunrise
            )
            fillSecondColumnData(weatherInfo.temp, weatherInfo.pressure, weatherInfo.sunset)
            fillThirdColumnData(
                weatherInfo.maxTemp,
                weatherInfo.minTemp,
                weatherInfo.wind,
                weatherInfo.dayTime
            )
        }
    }

    private fun prepareListeners() {
        with(activityHomeBinding) {
            searchBottomSheet.searchButton.setOnClickListener {
                loadData(searchBottomSheet.cityAutoCompleteTextView.text.toString())
                searchBottomSheet.cityAutoCompleteTextView.text.clear()
                hideKeyBoard()
            }

            searchBottomSheet.searchBeforeRecycleView
        }

        viewModel.error.observe(this, Observer {
            if (it) {
                Toast.makeText(
                    this,
                    getString(R.string.temp_error_when_search_weather),
                    Toast.LENGTH_LONG
                ).show()
                showWeatherDate(false)
            }
        })

        viewModel.weatherDTO.observe(this, Observer { weatherInfo ->
            if (weatherInfo != null) {
                prepareUi(weatherInfo)
            }
        })

        viewModel.readAllWeather.observe(this, Observer { itensFromDatabase ->
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            activityHomeBinding.searchBottomSheet.searchBeforeRecycleView.layoutManager = layoutManager
            activityHomeBinding.searchBottomSheet.searchBeforeRecycleView.adapter =
                CityAdapter(itensFromDatabase.map { weatherDTO -> weatherDTO.city }, this)
            allWeatherDatabse = itensFromDatabase
        })

        viewModel.readWeather.observe(this, Observer { weatherInfo ->
            if (weatherInfo != null) {
                prepareUi(weatherInfo)
            }
        })
    }

    private fun hasInternet(): Boolean {
        val cm = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        var result = false
        if (activeNetwork != null) {
            result = activeNetwork.isConnectedOrConnecting
        }
        return result
    }

    private fun hideKeyBoard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }

    private fun showWeatherDate(show: Boolean) {
        with(activityHomeBinding) {
            if (show) {
                tempEmptySearchLinearLayout.visibility = View.GONE
                tempInfoLinearLayout.visibility = View.VISIBLE
                dateAndcityInfoConstraintLayout.visibility = View.VISIBLE
            } else {
                tempEmptySearchLinearLayout.visibility = View.VISIBLE
                tempInfoLinearLayout.visibility = View.GONE
                dateAndcityInfoConstraintLayout.visibility = View.GONE
            }
        }
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
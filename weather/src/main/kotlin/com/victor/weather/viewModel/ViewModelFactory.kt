package com.victor.weather.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(context: Context)  : ViewModelProvider.Factory {

    private val baseContext : Context = context

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(baseContext) as T
    }

}
package com.victor.weather.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.victor.weather.R

class CityAdapter (nameList: List<String>, var ctx: Context): RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    internal var nameList: List<String> = ArrayList()

    init {
        this.nameList = nameList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.city_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = nameList[position]
        holder.cityName.text = name

    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var cityName = view.findViewById<TextView>(R.id.cityNameTextView)
    }
}
package com.victor.data.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.victor.data.model.Util.DataConverter
import com.victor.data.model.WeatherDTO

@Database(entities = [WeatherDTO::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao() : WeatherDao

    companion object {

        private val NAME_DATABASE = "weather_database"

        @Volatile
        private var INSTANCE : WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    NAME_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
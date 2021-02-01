package com.victor.data.model.Util

import androidx.room.TypeConverter
import java.util.*

object DataConverter {
        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }

        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return if (date == null) null else date.getTime()
        }
}
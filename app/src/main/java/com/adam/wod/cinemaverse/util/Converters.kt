package com.adam.wod.cinemaverse.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromList(list: List<String>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, type)
    }
}

class IntListTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromList(list: List<Int>): String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun toList(data: String): List<Int> {
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(data, type)
    }
}
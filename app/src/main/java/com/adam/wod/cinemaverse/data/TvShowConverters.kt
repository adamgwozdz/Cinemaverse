package com.adam.wod.cinemaverse.data

import androidx.room.TypeConverter
import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowResultsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object TvShowConverters {
    class TvShowPopularResultsEntityTypeConverter {
        private val gson = Gson()

        @TypeConverter
        fun fromList(list: List<PopularTvShowResultsEntity>): String {
            return gson.toJson(list)
        }

        @TypeConverter
        fun toList(data: String): List<PopularTvShowResultsEntity> {
            val type = object : TypeToken<List<PopularTvShowResultsEntity>>() {}.type
            return gson.fromJson(data, type)
        }
    }
}
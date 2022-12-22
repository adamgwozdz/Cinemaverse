package com.adam.wod.cinemaverse.data.tv_show.model.room

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tv_shows")
data class PopularTvShowEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "page") @SerializedName("page") val page: Int? = 0,
    @ColumnInfo(name = "results") @SerializedName("results") val results: List<PopularTvShowResultsEntity> = listOf(),
    @ColumnInfo(name = "total_results") @SerializedName("total_results") val totalResults: Int? = 0,
    @ColumnInfo(name = "total_pages") @SerializedName("total_pages") val totalPages: Int? = 0
)

@Entity
data class PopularTvShowResultsEntity(
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id") val id: Int = 0,
    @ColumnInfo(name = "backdrop_path") @SerializedName("backdrop_path") val backdropPath: String? = "",
    @ColumnInfo(name = "first_air_date") @SerializedName("first_air_date") val firstAirDate: String? = "",
    @ColumnInfo(name = "genre_ids") @SerializedName("genre_ids") val genreIds: List<Int>? = listOf(),
    @ColumnInfo(name = "name") @SerializedName("name") val name: String? = "",
    @ColumnInfo(name = "origin_country") @SerializedName("origin_country") val originCountry: List<String>? = listOf(),
    @ColumnInfo(name = "original_language") @SerializedName("original_language") val originalLanguage: String? = "",
    @ColumnInfo(name = "original_name") @SerializedName("original_name") val originalName: String? = "",
    @ColumnInfo(name = "overview") @SerializedName("overview") val overview: String? = "",
    @ColumnInfo(name = "popularity") @SerializedName("popularity") val popularity: Double? = 0.0,
    @ColumnInfo(name = "poster_path") @SerializedName("poster_path") val posterPath: String? = "",
    @ColumnInfo(name = "vote_average") @SerializedName("vote_average") val voteAverage: Double? = 0.0,
    @ColumnInfo(name = "vote_count") @SerializedName("vote_count") val voteCount: Int? = 0,
)
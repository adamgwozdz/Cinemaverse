package com.adam.wod.cinemaverse.repository.tv_show.model

import com.google.gson.annotations.SerializedName

interface TvShowDataContract {

    interface PopularTvShow {
        val id: Int?
        val backdropPath: String?
        val firstAirDate: String?
        val genreIds: List<Int>?
        val name: String?
        val originCountry: List<String>?
        val originalLanguage: String?
        val originalName: String?
        val overview: String?
        val popularity: Double?
        val posterPath: String?
        val voteAverage: Double?
        val voteCount: Int?

        val page: Int?
    }

    interface Response {
        data class FetchedPopularTvShows(
            @SerializedName("page") var page: Int = 0,
            @SerializedName("results") var results: List<FetchedTvShowResult> = emptyList(),
            @SerializedName("total_results") var totalResults: Int = 0,
            @SerializedName("total_pages") var totalPages: Int = 0
        )

        data class FetchedTvShowResult(
            @SerializedName("id") var id: Int = 0,
            @SerializedName("backdrop_path") var backdropPath: String = "",
            @SerializedName("first_air_date") var firstAirDate: String = "",
            @SerializedName("genre_ids") var genreIds: List<Int> = listOf(),
            @SerializedName("name") var name: String = "",
            @SerializedName("origin_country") var originCountry: List<String> = listOf(),
            @SerializedName("original_language") var originalLanguage: String = "",
            @SerializedName("original_name") var originalName: String = "",
            @SerializedName("overview") var overview: String = "",
            @SerializedName("popularity") var popularity: Double = 0.0,
            @SerializedName("poster_path") var posterPath: String = "",
            @SerializedName("vote_average") var voteAverage: Double = 0.0,
            @SerializedName("vote_count") var voteCount: Int = 0
        )
    }
}
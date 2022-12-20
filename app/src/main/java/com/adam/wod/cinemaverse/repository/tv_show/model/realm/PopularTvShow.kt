package com.adam.wod.cinemaverse.repository.tv_show.model.realm

import androidx.room.PrimaryKey
import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract

open class PopularTvShow (
    @PrimaryKey
    override val id: Int? = 0,
    override val backdropPath: String? = "",
    override val firstAirDate: String? = "",
    override val genreIds: List<Int>? = listOf(),
    override val name: String? = "",
    override val originCountry: List<String>? = listOf(),
    override val originalLanguage: String? = "",
    override val originalName: String? = "",
    override val overview: String? = "",
    override val popularity: Double? = 0.0,
    override val posterPath: String? = "",
    override val voteAverage: Double? = 0.0,
    override val voteCount: Int? = 0,

    override val page: Int? = 0
) : TvShowDataContract.PopularTvShow
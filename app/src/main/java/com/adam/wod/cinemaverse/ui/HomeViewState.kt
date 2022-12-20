package com.adam.wod.cinemaverse.ui

import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract

data class HomeViewState(
    val popularTvShows: List<TvShowDataContract.PopularTvShow> = listOf(),
    val isRefreshing: Boolean = false
)

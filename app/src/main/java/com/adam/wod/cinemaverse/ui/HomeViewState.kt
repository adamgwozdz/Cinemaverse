package com.adam.wod.cinemaverse.ui

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity

data class HomeViewState(
    val popularTvShows: PopularTvShowEntity,
    val isRefreshing: Boolean
)

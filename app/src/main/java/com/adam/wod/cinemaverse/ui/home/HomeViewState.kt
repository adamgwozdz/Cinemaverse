package com.adam.wod.cinemaverse.ui.home

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity

data class HomeViewState(
    val popularTvShows: PopularTvShowEntity = PopularTvShowEntity(),
    val isRefreshing: Boolean
)

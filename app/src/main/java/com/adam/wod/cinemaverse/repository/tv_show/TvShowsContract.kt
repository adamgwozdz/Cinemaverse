package com.adam.wod.cinemaverse.repository.tv_show

import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract

interface TvShowsContract {

    interface TvShowRepository {
        suspend fun fetchPopularTvShows(): List<TvShowDataContract.PopularTvShow>
    }

    interface TvShowUseCase {
        suspend fun getPopularTvShows(): List<TvShowDataContract.PopularTvShow>
    }
}
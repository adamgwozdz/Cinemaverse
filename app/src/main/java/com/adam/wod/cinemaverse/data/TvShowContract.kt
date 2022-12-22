package com.adam.wod.cinemaverse.data

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity

interface TvShowContract {

    interface TvShowRestRepository {
        suspend fun fetchPopularTvShows(): PopularTvShowEntity
    }

    interface TvShowLocalRepository {
        suspend fun getAll(): PopularTvShowEntity
        suspend fun save(tvShows: PopularTvShowEntity)
    }

    interface TvShowUseCase {
        suspend fun getPopularTvShows(): PopularTvShowEntity
    }
}
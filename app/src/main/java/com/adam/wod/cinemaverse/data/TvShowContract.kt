package com.adam.wod.cinemaverse.data

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import com.adam.wod.cinemaverse.data.tv_show.model.room.TvShowDetailsEntity

interface TvShowContract {

    interface TvShowRestRepository {
        suspend fun fetchPopularTvShows(): PopularTvShowEntity
        suspend fun fetchTvShowDetails(id: Int): TvShowDetailsEntity
    }

    interface TvShowUseCase {
        suspend fun getPopularTvShows(): PopularTvShowEntity
        suspend fun getTvShowDetails(showId: Int): TvShowDetailsEntity
    }
}
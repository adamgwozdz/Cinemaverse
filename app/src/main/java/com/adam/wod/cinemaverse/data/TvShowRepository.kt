package com.adam.wod.cinemaverse.data

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import com.adam.wod.cinemaverse.data.tv_show.model.room.TvShowDetailsEntity
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val tvShowsService: TvShowService
) : TvShowContract.TvShowRestRepository {

    override suspend fun fetchPopularTvShows(): PopularTvShowEntity {
        return tvShowsService.getPopularTvShows()
    }

    override suspend fun fetchTvShowDetails(id: Int): TvShowDetailsEntity {
        return tvShowsService.getDetails(id)
    }
}
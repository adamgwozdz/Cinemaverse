package com.adam.wod.cinemaverse.data

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private val tvShowsService: TvShowService,
    private val localRepository: TvShowContract.TvShowLocalRepository
) : TvShowContract.TvShowRestRepository {

    override suspend fun fetchPopularTvShows(): PopularTvShowEntity {
        val localData = localRepository.getAll()
        if (localData == null) {
            val response = tvShowsService.getPopularTvShows()
            localRepository.save(response)
            return response
        }
        return localData
    }
}
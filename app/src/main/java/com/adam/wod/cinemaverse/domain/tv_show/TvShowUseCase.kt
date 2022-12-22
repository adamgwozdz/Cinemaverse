package com.adam.wod.cinemaverse.domain.tv_show

import com.adam.wod.cinemaverse.data.TvShowContract
import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import javax.inject.Inject

class TvShowUseCase @Inject constructor(
    private val remoteRepository: TvShowContract.TvShowRestRepository
): TvShowContract.TvShowUseCase {

    override suspend fun getPopularTvShows(): PopularTvShowEntity {
        return remoteRepository.fetchPopularTvShows()
    }
}
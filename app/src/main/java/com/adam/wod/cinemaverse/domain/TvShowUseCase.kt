package com.adam.wod.cinemaverse.domain

import com.adam.wod.cinemaverse.repository.tv_show.TvShowsContract
import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract
import javax.inject.Inject

class TvShowUseCase @Inject constructor(
    private val remoteRepository: TvShowsContract.TvShowRepository
): TvShowsContract.TvShowUseCase {

    override suspend fun getPopularTvShows(): List<TvShowDataContract.PopularTvShow> {
        return remoteRepository.fetchPopularTvShows()
    }
}
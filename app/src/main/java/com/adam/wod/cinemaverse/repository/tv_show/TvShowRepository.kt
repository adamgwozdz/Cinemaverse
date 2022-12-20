package com.adam.wod.cinemaverse.repository.tv_show

import com.adam.wod.cinemaverse.util.Keys
import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract
import com.adam.wod.cinemaverse.repository.tv_show.model.realm.PopularTvShow
import com.adam.wod.cinemaverse.service.TvShowService
import javax.inject.Inject

class TvShowRepository @Inject constructor(private val tvShowsService: TvShowService) : TvShowsContract.TvShowRepository {

    override suspend fun fetchPopularTvShows(): List<TvShowDataContract.PopularTvShow> {
        val response = tvShowsService.getPopularTvShows("Bearer " + Keys.apiKey())
        val tvShows: MutableList<TvShowDataContract.PopularTvShow> = mutableListOf()
        response.results.forEach { tvShows.add(mapFetchedPopularTvShows(it, response.page)) }
        return tvShows
    }

    private fun mapFetchedPopularTvShows(
        fetchedTvShows: TvShowDataContract.Response.FetchedTvShowResult,
        page: Int
    ): PopularTvShow {
        return PopularTvShow(
            id = fetchedTvShows.id,
            backdropPath = fetchedTvShows.backdropPath,
            firstAirDate = fetchedTvShows.firstAirDate,
            genreIds = fetchedTvShows.genreIds,
            name = fetchedTvShows.name,
            originCountry = fetchedTvShows.originCountry,
            originalLanguage = fetchedTvShows.originalLanguage,
            originalName = fetchedTvShows.originalName,
            overview = fetchedTvShows.overview,
            popularity = fetchedTvShows.popularity,
            posterPath = fetchedTvShows.posterPath,
            voteAverage = fetchedTvShows.voteAverage,
            voteCount = fetchedTvShows.voteCount,
            page = page,
        )
    }
}
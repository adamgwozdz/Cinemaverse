package com.adam.wod.cinemaverse.service

import com.adam.wod.cinemaverse.repository.tv_show.model.TvShowDataContract
import retrofit2.http.GET

interface TvShowService {

    // Get a list of the current popular TV shows on TMDB. This list updates daily.
    @GET("4/tv/popular")
    suspend fun getPopularTvShows(): TvShowDataContract.Response.FetchedPopularTvShows
}
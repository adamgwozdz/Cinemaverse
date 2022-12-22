package com.adam.wod.cinemaverse.data

import com.adam.wod.cinemaverse.data.tv_show.model.room.PopularTvShowEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowService {

    /** Get the primary TV show details by id */
    @GET("tv/{tv_id}")
    suspend fun getDetails(
        @Path("tv_id") id: Int
    )

    /** Get the aggregate credits (cast and crew) that have been added to a TV show
     * It differs from credit call in that it does not return the newest season but rather,
     * is a view of the entire cast & crew for all episodes belonging to a TV show */
    @GET("tv/{tv_id}/aggregate_credits")
    suspend fun getAggregateCredits(
        @Path("tv_id") id: Int
    )

    /** Returns all of the alternative titles for a TV show */
    @GET("tv/{tv_id}/alternative_titles")
    suspend fun getAlternativeTitles(
        @Path("tv_id") id: Int
    )

    /** Get the changes for a TV show. By default only the last 24 hours are returned
     * You can query up to 14 days in a single query by using the start_date and end_date query parameters */
    @GET("tv/{tv_id}/changes")
    suspend fun getChanges(
        @Path("tv_id") id: Int,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("page") page: Int? = null
    )

    /** Get the list of content ratings (certifications) that have been added to a TV show */
    @GET("tv/{tv_id}/content_ratings")
    suspend fun getContentRatings(
        @Path("tv_id") id: Int
    )

    /** Get the credits (cast and crew) that have been added to a TV show */
    @GET("tv/{tv_id}/credits")
    suspend fun getCredits(
        @Path("tv_id") id: Int
    )

    /** Get all of the episode groups that have been created for a TV show */
    @GET("tv/{tv_id}/episode_groups")
    suspend fun getEpisodeGroups(
        @Path("tv_id") id: Int
    )

    /** Get the external ids for a TV show. We currently support the following external sources */
    @GET("tv/{tv_id}/external_ids")
    suspend fun getExternalIDs(
        @Path("tv_id") id: Int
    )

    /** Get the images that belong to a TV show */
    @GET("tv/{tv_id}/images")
    suspend fun getImages(
        @Path("tv_id") id: Int
    )

    /** Get the keywords that have been added to a TV show */
    @GET("tv/{tv_id}/keywords")
    suspend fun getKeywords(
        @Path("tv_id") id: Int
    )

    /** Get the list of TV show recommendations for this item */
    @GET("tv/{tv_id}/recommendations")
    suspend fun getRecommendations(
        @Path("tv_id") id: Int,
        @Query("page") page: Int? = null
    )

    /** Get the reviews for a TV show */
    @GET("tv/{tv_id}/reviews")
    suspend fun getReviews(
        @Path("tv_id") id: Int,
        @Query("page") page: Int? = null
    )

    /** Get a list of seasons or episodes that have been screened in a film festival or theatre */
    @GET("tv/{tv_id}/screened_theatrically")
    suspend fun getScreenedTheatrically(
        @Path("tv_id") id: Int
    )

    /** Get a list of similar TV shows. These items are assembled by looking at keywords and genres */
    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTVShows(
        @Path("tv_id") id: Int,
        @Query("page") page: Int? = null
    )

    /** Get a list of the translations that exist for a TV show */
    @GET("tv/{tv_id}/translations")
    suspend fun getTranslations(
        @Path("tv_id") id: Int
    )

    /** Get the videos that have been added to a TV show */
    @GET("tv/{tv_id}/videos")
    suspend fun getVideos(
        @Path("tv_id") id: Int
    )

    //TODO If used, attribute the source of the data as JustWatch
    /** Get a list of the availabilities per country by provider */
    @GET("tv/{tv_id}/watch/providers")
    suspend fun getWatchProviders(
        @Path("tv_id") id: Int
    )

    /** Get the most newly created TV show. This is a live response and will continuously change */
    @GET("tv/latest")
    suspend fun getLatest()

    /** Get a list of TV shows that are airing today. This query is purely day based as we do not currently support airing times */
    @GET("tv/airing_today")
    suspend fun getTVAiringToday(
        @Query("page") page: Int? = null
    )

    /** Get a list of shows that are currently on the air.
     * This query looks for any TV show that has an episode with an air date in the next 7 days */
    @GET("tv/on_the_air")
    suspend fun getTVOnTheAir(
        @Query("page") page: Int? = null
    )

    /** Get a list of the current popular TV shows on TMDB. This list updates daily */
    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("page") page: Int? = null
    ): PopularTvShowEntity

    /** Get a list of the top rated TV shows on TMDB */
    @GET("tv/top_rated")
    suspend fun getTopRated(
        @Query("page") page: Int? = null
    )
}
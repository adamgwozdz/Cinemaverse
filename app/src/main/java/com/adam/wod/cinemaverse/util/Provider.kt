package com.adam.wod.cinemaverse.util

import com.adam.wod.cinemaverse.domain.TvShowUseCase
import com.adam.wod.cinemaverse.repository.tv_show.TvShowRepository
import com.adam.wod.cinemaverse.repository.tv_show.TvShowsContract
import com.adam.wod.cinemaverse.service.TvShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Provider {

    @Provides
    @Singleton
    fun provideTvShowAuthOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
//            .addInterceptor(Class())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/")
            .build()
    }

    @Provides
    @Singleton
    fun provideTvShowsService(retrofit: Retrofit): TvShowService {
        return retrofit.create(TvShowService::class.java)
    }

    @Provides
    @Singleton
    fun provideTvShowsRepository(tvShowService: TvShowService): TvShowsContract.TvShowRepository {
        return TvShowRepository(tvShowService)
    }

    @Provides
    @Singleton
    fun provideTvShowsUseCase(tvShowRepository: TvShowRepository): TvShowsContract.TvShowUseCase {
        return TvShowUseCase(tvShowRepository)
    }
}
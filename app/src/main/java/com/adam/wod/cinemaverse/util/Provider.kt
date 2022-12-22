package com.adam.wod.cinemaverse.util

import android.content.Context
import androidx.room.Room
import com.adam.wod.cinemaverse.domain.tv_show.TvShowUseCase
import com.adam.wod.cinemaverse.data.TvShowContract
import com.adam.wod.cinemaverse.data.tv_show.AppDatabase
import com.adam.wod.cinemaverse.data.tv_show.PopularTvShowLocalRepository
import com.adam.wod.cinemaverse.data.TvShowRepository
import com.adam.wod.cinemaverse.data.TvShowService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
            .addInterceptor(Interceptor())
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
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
    }

    @Provides
    @Singleton
    fun provideTvShowsService(retrofit: Retrofit): TvShowService {
        return retrofit.create(TvShowService::class.java)
    }

    @Provides
    @Singleton
    fun provideTvShowsRepository(
        tvShowService: TvShowService,
        tvShowDatabase: PopularTvShowLocalRepository
    ): TvShowContract.TvShowRestRepository {
        return TvShowRepository(tvShowService, tvShowDatabase)
    }

    @Provides
    @Singleton()
    fun provideLocalTvShowsRepository(@ApplicationContext context: Context): TvShowContract.TvShowLocalRepository {
        val dataBase = Room.databaseBuilder(context, AppDatabase::class.java, "CinemaverseDB").build()
        return PopularTvShowLocalRepository(dataBase)
    }

    @Provides
    @Singleton
    fun provideTvShowsUseCase(tvShowRepository: TvShowRepository): TvShowContract.TvShowUseCase {
        return TvShowUseCase(tvShowRepository)
    }
}
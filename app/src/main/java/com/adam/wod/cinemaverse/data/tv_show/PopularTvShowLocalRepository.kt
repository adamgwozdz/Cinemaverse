package com.adam.wod.cinemaverse.data.tv_show

import androidx.room.*
import com.adam.wod.cinemaverse.data.TvShowConverters
import com.adam.wod.cinemaverse.data.TvShowContract
import com.adam.wod.cinemaverse.data.tv_show.model.room.*
import com.adam.wod.cinemaverse.util.IntListTypeConverter
import com.adam.wod.cinemaverse.util.StringListTypeConverter
import javax.inject.Inject

class PopularTvShowLocalRepository @Inject constructor(private val database: AppDatabase) :
    TvShowContract.TvShowLocalRepository {

    override suspend fun getAll(): PopularTvShowEntity {
        return database.tvShowPopularDao().getAll()
    }

    override suspend fun save(tvShows: PopularTvShowEntity) {
        database.tvShowPopularDao().insert(tvShows)
    }
}

@Dao
abstract class TvShowPopularDao {
    @Transaction
    @Query("select * from popular_tv_shows")
    abstract suspend fun getAll(): PopularTvShowEntity

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(tvShows: PopularTvShowEntity)
}

@Database(
    entities = [PopularTvShowEntity::class, PopularTvShowResultsEntity::class],
    version = 1
)
@TypeConverters(
    TvShowConverters.TvShowPopularResultsEntityTypeConverter::class,
    IntListTypeConverter::class,
    StringListTypeConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tvShowPopularDao(): TvShowPopularDao
}
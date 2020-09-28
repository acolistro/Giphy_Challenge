package com.test.giphy_challenge.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TrendingGif::class],
    version = 1, exportSchema = false
)
abstract class GifDatabase : RoomDatabase() {
    abstract val trendingGifDao: TrendingGifDao

}
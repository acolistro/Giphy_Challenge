package com.test.giphy_challenge.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TrendingGifDao {
    @Query("select * from trending_gif")
    fun getTrending(): LiveData<List<TrendingGif>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(trending: List<TrendingGif>)
}
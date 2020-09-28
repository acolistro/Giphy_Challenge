package com.test.giphy_challenge.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.test.giphy_challenge.database.GifDatabase
import com.test.giphy_challenge.database.asDomainModel
import com.test.giphy_challenge.domain.GifTrending
import com.test.giphy_challenge.network.Constants
import com.test.giphy_challenge.network.Service
import com.test.giphy_challenge.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GifRepository(private val service: Service, private val database: GifDatabase) {

    suspend fun refreshTrendingGifs() {
        withContext(Dispatchers.IO) {
            val trendingList =
                service.getTrendingListAsync(Constants.API_KEY, Constants.limit, Constants.rating)
                    .await()
            database.trendingGifDao.insertAll(trendingList.asDatabaseModel())
        }
    }

    val gifTrending: LiveData<List<GifTrending>> =
        Transformations.map(database.trendingGifDao.getTrending()) {
            it.asDomainModel()
        }
}
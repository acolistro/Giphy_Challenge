package com.test.giphy_challenge.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("gifs/trending")
    fun getTrendingListAsync(
        @Query("api_key") api_key: String?,
        @Query("limit") limit: Int?,
        @Query("rating") rating: String?
    ): Deferred<GiphyResponse>
}
package com.test.giphy_challenge.database

import com.test.giphy_challenge.domain.GifTrending


fun List<TrendingGif>.asDomainModel():List<GifTrending> {
    return map {
        GifTrending(
            id = it.id,
            url = it.url,
            title = it.title
        )
    }
}
package com.test.giphy_challenge.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.test.giphy_challenge.domain.GifTrending

@Entity(tableName= "trending_gif")
data class TrendingGif(
    @PrimaryKey
    var id: String,
    var url: String,
    var title: String
)
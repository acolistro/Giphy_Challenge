package com.test.giphy_challenge.network

import com.google.gson.annotations.SerializedName
import com.test.giphy_challenge.database.TrendingGif

data class GiphyResponse(val data: List<ResponseData>)

data class ResponseData(
    @SerializedName("images")
    val images: Images,

    @SerializedName("title")
    var title: String,

    @SerializedName("id")
    var id: String

)

data class Images(

    @SerializedName("original")
    val original: Original
)

data class Original(

    @SerializedName("url")
    val url: String

)

fun GiphyResponse.asDatabaseModel(): List<TrendingGif> {
    return data.map {
        TrendingGif(
            id = it.id,
            title = it.title,
            url = it.images.original.url

        )
    }
}

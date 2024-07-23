package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageX(
    @Json(name = "height")
    val height: Int?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "width")
    val width: Int?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ImageDto(
    @Json(name = "height")
    val height: Int?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "width")
    val width: Int?,
    @Json(name = "with_padding")
    val withPadding: Int?
)
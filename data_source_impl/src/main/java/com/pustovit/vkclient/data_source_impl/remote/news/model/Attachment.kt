package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attachment(
    @Json(name = "photo")
    val photo: Photo?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "video")
    val video: Video?
)
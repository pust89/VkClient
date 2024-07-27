package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class AttachmentDto(
    @Json(name = "photo")
    val photo: PhotoDto?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "video")
    val video: VideoDto?
)
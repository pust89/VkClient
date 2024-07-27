package com.pustovit.vkclient.data_source_impl.remote.likes.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class LikesContentDto(
    @Json(name = "likes")
    val likes: Int?,
)
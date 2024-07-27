package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PostSourceDto(
    @Json(name = "platform")
    val platform: String?,
    @Json(name = "type")
    val type: String?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ReactionsDto(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "items")
    val items: List<ItemXDto>?
)
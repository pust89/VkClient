package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Reactions(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "items")
    val items: List<ItemX>?
)
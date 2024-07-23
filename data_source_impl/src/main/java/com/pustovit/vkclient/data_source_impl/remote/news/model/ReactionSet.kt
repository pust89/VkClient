package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReactionSet(
    @Json(name = "id")
    val id: String?,
    @Json(name = "items")
    val items: List<ItemXX>?
)
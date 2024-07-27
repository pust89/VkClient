package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ItemXDto(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "id")
    val id: Int?
)
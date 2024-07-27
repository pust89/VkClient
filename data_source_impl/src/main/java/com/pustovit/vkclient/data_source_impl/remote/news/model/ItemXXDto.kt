package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ItemXXDto(
    @Json(name = "asset")
    val asset: AssetDto?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?
)
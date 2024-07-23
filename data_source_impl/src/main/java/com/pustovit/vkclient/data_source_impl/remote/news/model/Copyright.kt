package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Copyright(
    @Json(name = "link")
    val link: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "type")
    val type: String?
)
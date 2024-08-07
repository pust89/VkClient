package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class BackgroundDto(
    @Json(name = "dark")
    val dark: String?,
    @Json(name = "light")
    val light: String?
)
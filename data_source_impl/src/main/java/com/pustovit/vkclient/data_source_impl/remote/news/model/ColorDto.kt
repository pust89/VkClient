package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class ColorDto(
    @Json(name = "background")
    val background: BackgroundDto?,
    @Json(name = "foreground")
    val foreground: ForegroundDto?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Asset(
    @Json(name = "animation_url")
    val animationUrl: String?,
    @Json(name = "images")
    val images: List<ImageX>?,
    @Json(name = "title")
    val title: Title?,
    @Json(name = "title_color")
    val titleColor: TitleColor?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class AssetDto(
    @Json(name = "animation_url")
    val animationUrl: String?,
    @Json(name = "images")
    val images: List<ImageXDto>?,
    @Json(name = "title")
    val title: TitleDto?,
    @Json(name = "title_color")
    val titleColor: TitleColorDto?
)
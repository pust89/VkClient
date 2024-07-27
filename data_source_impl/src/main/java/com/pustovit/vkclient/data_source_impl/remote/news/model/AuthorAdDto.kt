package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class AuthorAdDto(
    @Json(name = "advertiser_info_url")
    val advertiserInfoUrl: String?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class OnlineInfoDto(
    @Json(name = "app_id")
    val appId: Int?,
    @Json(name = "is_mobile")
    val isMobile: Boolean?,
    @Json(name = "is_online")
    val isOnline: Boolean?,
    @Json(name = "last_seen")
    val lastSeen: Int?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "visible")
    val visible: Boolean?
)
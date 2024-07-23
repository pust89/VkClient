package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Profile(
    @Json(name = "can_access_closed")
    val canAccessClosed: Boolean?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "is_closed")
    val isClosed: Boolean?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "online")
    val online: Int?,
    @Json(name = "online_app")
    val onlineApp: Int?,
    @Json(name = "online_info")
    val onlineInfo: OnlineInfo?,
    @Json(name = "online_mobile")
    val onlineMobile: Int?,
    @Json(name = "photo_100")
    val photo100: String?,
    @Json(name = "photo_50")
    val photo50: String?,
    @Json(name = "photo_base")
    val photoBase: String?,
    @Json(name = "screen_name")
    val screenName: String?,
    @Json(name = "sex")
    val sex: Int?
)
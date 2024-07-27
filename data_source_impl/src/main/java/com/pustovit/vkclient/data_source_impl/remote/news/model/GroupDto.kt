package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GroupDto(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "is_admin")
    val isAdmin: Int?,
    @Json(name = "is_advertiser")
    val isAdvertiser: Int?,
    @Json(name = "is_closed")
    val isClosed: Int?,
    @Json(name = "is_member")
    val isMember: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "photo_100")
    val photo100: String?,
    @Json(name = "photo_200")
    val photo200: String?,
    @Json(name = "photo_50")
    val photo50: String?,
    @Json(name = "photo_base")
    val photoBase: String?,
    @Json(name = "screen_name")
    val screenName: String?,
    @Json(name = "type")
    val type: String?
)
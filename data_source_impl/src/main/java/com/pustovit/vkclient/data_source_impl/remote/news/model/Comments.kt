package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comments(
    @Json(name = "can_post")
    val canPost: Int?,
    @Json(name = "can_view")
    val canView: Int?,
    @Json(name = "count")
    val count: Int?,
    @Json(name = "groups_can_post")
    val groupsCanPost: Boolean?
)
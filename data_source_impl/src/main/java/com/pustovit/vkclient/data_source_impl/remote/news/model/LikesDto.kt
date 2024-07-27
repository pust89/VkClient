package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class LikesDto(
    @Json(name = "can_like")
    val canLike: Int?,
    @Json(name = "can_publish")
    val canPublish: Int?,
    @Json(name = "count")
    val count: Int?,
    @Json(name = "repost_disabled")
    val repostDisabled: Boolean?,
    @Json(name = "user_likes")
    val userLikes: Int?
)
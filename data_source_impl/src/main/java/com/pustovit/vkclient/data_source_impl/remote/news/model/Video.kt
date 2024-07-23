package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Video(
    @Json(name = "access_key")
    val accessKey: String?,
    @Json(name = "can_add")
    val canAdd: Int?,
    @Json(name = "can_add_to_faves")
    val canAddToFaves: Int?,
    @Json(name = "can_comment")
    val canComment: Int?,
    @Json(name = "can_dislike")
    val canDislike: Int?,
    @Json(name = "can_like")
    val canLike: Int?,
    @Json(name = "can_repost")
    val canRepost: Int?,
    @Json(name = "can_subscribe")
    val canSubscribe: Int?,
    @Json(name = "comments")
    val comments: Int?,
    @Json(name = "date")
    val date: Int?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "duration")
    val duration: Int?,
    @Json(name = "first_frame")
    val firstFrame: List<FirstFrame?>?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: List<Image?>?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "local_views")
    val localViews: Int?,
    @Json(name = "owner_id")
    val ownerId: Int?,
    @Json(name = "processing")
    val processing: Int?,
    @Json(name = "response_type")
    val responseType: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "track_code")
    val trackCode: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "user_id")
    val userId: Int?,
    @Json(name = "views")
    val views: Int?,
    @Json(name = "width")
    val width: Int?
)
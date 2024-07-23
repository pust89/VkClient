package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Photo(
    @Json(name = "access_key")
    val accessKey: String?,
    @Json(name = "album_id")
    val albumId: Int?,
    @Json(name = "date")
    val date: Int?,
    @Json(name = "has_tags")
    val hasTags: Boolean?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "long")
    val long: Double?,
    @Json(name = "orig_photo")
    val origPhoto: OrigPhoto?,
    @Json(name = "owner_id")
    val ownerId: Int?,
    @Json(name = "post_id")
    val postId: Int?,
    @Json(name = "sizes")
    val sizes: List<Size?>?,
    @Json(name = "tags")
    val tags: Tags?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "user_id")
    val userId: Int?,
    @Json(name = "web_view_token")
    val webViewToken: String?
)
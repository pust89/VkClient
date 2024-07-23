package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedPostDto(
    @Json(name = "attachments")
    val attachments: List<Attachment>?,
    @Json(name = "author_ad")
    val authorAd: AuthorAd?,
    @Json(name = "carousel_offset")
    val carouselOffset: Int?,
    @Json(name = "comments")
    val comments: Comments?,
    @Json(name = "copyright")
    val copyright: Copyright?,
    @Json(name = "date")
    val date: Int?,
    @Json(name = "donut")
    val donut: Donut?,
    @Json(name = "edited")
    val edited: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "inner_type")
    val innerType: String?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "likes")
    val likes: Likes?,
    @Json(name = "marked_as_ads")
    val markedAsAds: Int?,
    @Json(name = "owner_id")
    val ownerId: Int?,
    @Json(name = "post_id")
    val postId: Int?,
    @Json(name = "post_source")
    val postSource: PostSource?,
    @Json(name = "post_type")
    val postType: String?,
    @Json(name = "reaction_set_id")
    val reactionSetId: String?,
    @Json(name = "reactions")
    val reactions: Reactions?,
    @Json(name = "reposts")
    val reposts: Reposts?,
    @Json(name = "signer_id")
    val signerId: Int?,
    @Json(name = "source_id")
    val sourceId: Int?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "views")
    val views: Views?
)
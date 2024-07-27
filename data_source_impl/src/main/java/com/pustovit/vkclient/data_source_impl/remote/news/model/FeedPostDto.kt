package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class FeedPostDto(
    @Json(name = "attachments")
    val attachments: List<AttachmentDto>?,
    @Json(name = "author_ad")
    val authorAd: AuthorAdDto?,
    @Json(name = "carousel_offset")
    val carouselOffset: Int?,
    @Json(name = "comments")
    val comments: CommentsDto?,
    @Json(name = "copyright")
    val copyright: CopyrightDto?,
    @Json(name = "date")
    val date: Int?,
    @Json(name = "donut")
    val donut: DonutDto?,
    @Json(name = "edited")
    val edited: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "inner_type")
    val innerType: String?,
    @Json(name = "is_favorite")
    val isFavorite: Boolean?,
    @Json(name = "likes")
    val likes: LikesDto?,
    @Json(name = "marked_as_ads")
    val markedAsAds: Int?,
    @Json(name = "owner_id")
    val ownerId: Int?,
    @Json(name = "post_id")
    val postId: Int?,
    @Json(name = "post_source")
    val postSource: PostSourceDto?,
    @Json(name = "post_type")
    val postType: String?,
    @Json(name = "reaction_set_id")
    val reactionSetId: String?,
    @Json(name = "reactions")
    val reactions: ReactionsDto?,
    @Json(name = "reposts")
    val reposts: RepostsDto?,
    @Json(name = "signer_id")
    val signerId: Int?,
    @Json(name = "source_id")
    val sourceId: Int?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "views")
    val views: ViewsDto?
)
package com.pustovit.vkclient.data_source_impl.remote.news.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class FeedPostResponseDto(
    @Json(name = "groups")
    val groups: List<GroupDto>?,
    @Json(name = "items")
    val items: List<FeedPostDto>?,
    @Json(name = "next_from")
    val nextFrom: String?,
    @Json(name = "profiles")
    val profiles: List<ProfileDto>?,
    @Json(name = "reaction_sets")
    val reactionSets: List<ReactionSetDto>?
)
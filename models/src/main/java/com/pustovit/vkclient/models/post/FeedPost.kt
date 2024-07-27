package com.pustovit.vkclient.models.post


data class FeedPost(
    val id: Int = 0,
    val ownerId: Int = 0,
    val type: String = "",
    val communityName: String = "/dev/null",
    val publicationDate: String = "14:00",
    val communityImageUrl: String = "https://placehold.co/600x400.png",
    val contentText: String = "Lo//?123-!\rem ipsum dolor sit amet, consectetur adipiscing elit.",
    val attachment: Attachment? = null,
    val viewsCount: Int = 123,
    val repostsCount: Int = 456,
    val commentsCount: Int = 11,
    val likes: Likes = Likes(11, false),
) {

    data class Likes(
        val count: Int,
        val isLiked: Boolean
    )
}

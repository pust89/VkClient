package com.pustovit.vkclient.domain.model


data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarUrl: String = "https://placehold.co/600x400.png",
    val commentText: String = "Long comment text",
    val publicationDate: String = "14:00"
)

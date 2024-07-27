package com.pustovit.vkclient.models.post

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 15:34
 */
sealed class Attachment(
    open val id: Int,
    open val ownerId: Int,
) {

    data class Photo(
        override val id: Int,
        override val ownerId: Int,
        val imageUrl: String,
    ) : Attachment(id, ownerId)

    data class Video(override val id: Int, override val ownerId: Int) : Attachment(id, ownerId)
}
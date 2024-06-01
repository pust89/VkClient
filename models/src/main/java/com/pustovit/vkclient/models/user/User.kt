package com.pustovit.vkclient.models.user

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:18
 */
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isClosed: Boolean,
    val canAccessClosed: Boolean,
)
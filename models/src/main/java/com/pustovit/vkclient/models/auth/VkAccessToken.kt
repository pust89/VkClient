package com.pustovit.vkclient.models.auth

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:43
 */
data class VkAccessToken(
    val token: String,
    val userID: Long,
    val expireTime: Long,
    val userData: VKIDUser,
)
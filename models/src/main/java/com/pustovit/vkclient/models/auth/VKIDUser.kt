package com.pustovit.vkclient.models.auth

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:44
 */
data class VKIDUser(
    val firstName: String,
    val lastName: String,
    val phone: String? = null,
    val photo50: String? = null,
    val photo100: String? = null,
    val photo200: String? = null,
    val email: String? = null
)
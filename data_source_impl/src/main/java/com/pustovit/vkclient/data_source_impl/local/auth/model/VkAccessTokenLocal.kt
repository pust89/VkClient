package com.pustovit.vkclient.data_source_impl.local.auth.model

/**
 * Created by Pustovit V.V.
 * Date: 09.04.2024
 * Time: 21:38
 */
internal data class VkAccessTokenLocal(
    val token: String,
    val userID: Long,
    val expireTime: Long,
    val userData: VKIDUserLocal,
)
package com.pustovit.vkclient.data_local_source_impl.auth.model

import com.pustovit.vkclient.models.auth.VKIDUser
import com.pustovit.vkclient.models.auth.VkAccessToken

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
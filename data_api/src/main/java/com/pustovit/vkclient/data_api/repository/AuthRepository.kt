package com.pustovit.vkclient.data_api.repository

import com.pustovit.vkclient.models.auth.VkAccessToken

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:42
 */
interface AuthRepository {
    suspend fun getVkAccessToken(): VkAccessToken?
    suspend fun saveVkAccessToken(token: VkAccessToken)
}
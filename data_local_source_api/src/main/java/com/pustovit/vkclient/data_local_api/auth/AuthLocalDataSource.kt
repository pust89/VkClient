package com.pustovit.vkclient.data_local_api.auth

import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:58
 */
interface AuthLocalDataSource {
    suspend fun getVkAccessToken(): VkAccessToken?
    suspend fun saveVkAccessToken(token: VkAccessToken)
}
package com.pustovit.vkclient.data_api.repository

import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:42
 */
interface AuthRepository {
    fun getVkAccessToken(): Flow<VkAccessToken?>
    fun saveVkAccessToken(token: VkAccessToken): Flow<Unit>
}
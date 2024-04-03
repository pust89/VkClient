package com.pustovit.vkclient.data_impl.repository.auth

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_local_api.auth.AuthLocalDataSource
import com.pustovit.vkclient.models.auth.VkAccessToken
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:48
 */
internal class AuthRepositoryImpl @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun getVkAccessToken(): VkAccessToken? {
        return authLocalDataSource.getVkAccessToken()
    }

    override suspend fun saveVkAccessToken(token: VkAccessToken) {
        authLocalDataSource.saveVkAccessToken(token)
    }
}
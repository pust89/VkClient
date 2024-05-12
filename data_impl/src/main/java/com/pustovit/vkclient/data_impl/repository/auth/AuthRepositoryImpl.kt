package com.pustovit.vkclient.data_impl.repository.auth

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 21:48
 */
internal class AuthRepositoryImpl @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override fun getVkAccessToken(): Flow<VkAccessToken?> = flow {
        emit(authLocalDataSource.getVkAccessToken())
    }.flowOn(Dispatchers.IO)

    override fun saveVkAccessToken(token: VkAccessToken): Flow<Unit> = flow {
        emit(authLocalDataSource.saveVkAccessToken(token))
    }.flowOn(Dispatchers.IO)
}
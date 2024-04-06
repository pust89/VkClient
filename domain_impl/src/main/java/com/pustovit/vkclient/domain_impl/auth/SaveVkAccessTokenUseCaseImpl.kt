package com.pustovit.vkclient.domain_impl.auth

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:33
 */
class SaveVkAccessTokenUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SaveVkAccessTokenUseCase {
    override fun invoke(token: VkAccessToken): Flow<Unit> {
        return authRepository.saveVkAccessToken(token)
    }
}
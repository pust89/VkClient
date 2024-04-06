package com.pustovit.vkclient.domain_impl.auth

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.models.auth.VkAccessToken
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:31
 */
internal class GetVkAccessTokenUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : GetVkAccessTokenUseCase {
    override fun invoke(): Flow<VkAccessToken?> {
        return authRepository.getVkAccessToken()
    }
}
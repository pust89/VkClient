package com.pustovit.vkclient.domain_impl.auth

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.05.2024
 * Time: 15:04
 */
internal class LogoutUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
) : LogoutUseCase {

    override fun invoke(): Flow<Unit> {
        return authRepository.clearVkAccessToken()
    }
}
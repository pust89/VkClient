package com.pustovit.vkclient.domain_impl.user

import com.pustovit.vkclient.data_api.repository.UserRepository
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.models.user.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:24
 */
internal class GetCurrentUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetCurrentUserUseCase {
    override fun invoke(): Flow<User> {
        return userRepository.getCurrentUser()
    }
}
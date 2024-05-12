package com.pustovit.vkclient.domain_api.user

import com.pustovit.vkclient.models.user.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:23
 */
interface GetCurrentUserUseCase {
    operator fun invoke(): Flow<User>

}
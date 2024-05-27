package com.pustovit.vkclient.domain_api.auth

import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 27.05.2024
 * Time: 14:35
 */
interface LogoutUseCase {

    operator fun invoke(): Flow<Unit>

}
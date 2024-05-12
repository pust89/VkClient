package com.pustovit.vkclient.data_api.repository

import com.pustovit.vkclient.models.user.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:17
 */
interface UserRepository {
    fun getCurrentUser(): Flow<User>
}
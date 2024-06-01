package com.pustovit.vkclient.data_source_api.remote

import com.pustovit.vkclient.models.user.User

/**
 * Created by Pustovit V.V.
 * Date: 29.05.2024
 * Time: 11:21
 */
interface UserRemoteDataSource {
    suspend fun getCurrentUser(): User
}
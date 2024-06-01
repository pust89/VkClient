package com.pustovit.vkclient.data_source_impl.remote.user

import com.pustovit.vkclient.data_source_api.remote.UserRemoteDataSource
import com.pustovit.vkclient.data_source_impl.remote.user.api.UserApi
import com.pustovit.vkclient.data_source_impl.remote.user.mapper.UserModelMapper
import com.pustovit.vkclient.data_source_impl.service.process
import com.pustovit.vkclient.models.user.User
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 17:57
 */
internal class UserRemoteDataSourceImpl @Inject constructor(
    private val api: UserApi,
    private val mapper: UserModelMapper,
) : UserRemoteDataSource {

    override suspend fun getCurrentUser(): User {
        return api.getCurrentUser().process { dto ->
            mapper.map(dto)
        }
    }
}
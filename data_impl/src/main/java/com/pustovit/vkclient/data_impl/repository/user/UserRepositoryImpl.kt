package com.pustovit.vkclient.data_impl.repository.user

import com.pustovit.vkclient.data_api.repository.UserRepository
import com.pustovit.vkclient.models.user.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:19
 */
internal class UserRepositoryImpl @Inject constructor() : UserRepository {

    override fun getCurrentUser(): Flow<User> {
        return flow {
            delay(1500)
            emit(User(name = "Mock User Name"))
        }.flowOn(Dispatchers.IO)
    }
}
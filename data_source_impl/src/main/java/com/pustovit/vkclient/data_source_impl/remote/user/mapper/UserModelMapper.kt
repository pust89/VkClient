package com.pustovit.vkclient.data_source_impl.remote.user.mapper

import com.pustovit.vkclient.data_source_impl.remote.user.model.UserDto
import com.pustovit.vkclient.models.error.VkError
import com.pustovit.vkclient.models.user.User
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:11
 */
internal class UserModelMapper @Inject constructor() {

    fun map(dto: List<UserDto>?): User {
        val userDto =  dto?.firstOrNull()?: throw VkError(errorCode = 0, message = "User is null")
        return  User(
            id = userDto.id ?: 0,
            firstName = userDto.firstName.orEmpty(),
            lastName = userDto.lastName.orEmpty(),
            isClosed = userDto.isClosed ?: false,
            canAccessClosed = userDto.canAccessClosed ?: false
        )
    }
}
package com.pustovit.vkclient.data_source_impl.remote.user.api

import com.pustovit.vkclient.data_source_impl.remote.user.model.UserDto
import com.pustovit.vkclient.data_source_impl.remote.base.VkResponse
import retrofit2.http.GET

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:07
 */
internal interface UserApi {

    @GET("users.get")
    suspend fun getCurrentUser(): VkResponse<List<UserDto>>
}
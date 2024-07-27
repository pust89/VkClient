package com.pustovit.vkclient.data_api

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.data_api.repository.UserRepository

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:48
 */
interface DataApi {

    fun userRepository(): UserRepository

    fun authRepository(): AuthRepository

    fun feedPostRepository(): FeedPostRepository

    fun likesRepository(): LikesRepository
}
package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.data_api.repository.UserRepository

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:17
 */

interface DomainDependencies {

    fun authRepository(): AuthRepository

    fun userRepository(): UserRepository

    fun feedPostRepository(): FeedPostRepository

    fun likesRepository(): LikesRepository
}
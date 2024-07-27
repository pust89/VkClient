package com.pustovit.vkclient.data_impl.di

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.data_api.repository.UserRepository
import com.pustovit.vkclient.data_impl.repository.auth.AuthRepositoryImpl
import com.pustovit.vkclient.data_impl.repository.likes.LikesRepositoryImpl
import com.pustovit.vkclient.data_impl.repository.news.FeedPostRepositoryImpl
import com.pustovit.vkclient.data_impl.repository.user.UserRepositoryImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:01
 */
@Module
internal interface RepositoryModule {

    @Binds
    @FeatureScope
    fun bindAuthRepository(repository: AuthRepositoryImpl): AuthRepository

    @Binds
    @FeatureScope
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    @FeatureScope
    fun bindFeedPostRepository(repository: FeedPostRepositoryImpl): FeedPostRepository

    @Binds
    @FeatureScope
    fun bindLikesRepository(repository: LikesRepositoryImpl): LikesRepository
}
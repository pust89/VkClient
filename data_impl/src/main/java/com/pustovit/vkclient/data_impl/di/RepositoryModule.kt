package com.pustovit.vkclient.data_impl.di

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_impl.repository.FeedPostRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:01
 */
@Module
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun bindFeedPostRepository(repository: FeedPostRepositoryImpl): FeedPostRepository
}
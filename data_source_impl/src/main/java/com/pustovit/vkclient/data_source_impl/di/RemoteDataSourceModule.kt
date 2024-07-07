package com.pustovit.vkclient.data_source_impl.di

import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.data_source_api.remote.UserRemoteDataSource
import com.pustovit.vkclient.data_source_impl.remote.news.FeedPostRemoteDataSourceImpl
import com.pustovit.vkclient.data_source_impl.remote.user.UserRemoteDataSourceImpl
import com.pustovit.vkclient.data_source_impl.remote.user.api.UserApi
import com.pustovit.vkclient.data_source_impl.remote.user.mapper.UserModelMapper
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 30.05.2024
 * Time: 15:59
 */
@Module
internal interface RemoteDataSourceModule {

    @Binds
    @FeatureScope
    fun bindsUserRemoteDataSource(source: UserRemoteDataSourceImpl): UserRemoteDataSource

    @Binds
    @FeatureScope
    fun bindsFeedPostRemoteDataSource(source: FeedPostRemoteDataSourceImpl): FeedPostRemoteDataSource
}
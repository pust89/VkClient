package com.pustovit.vkclient.data_impl.di

import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.data_source_api.remote.UserRemoteDataSource

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:23
 */
interface DataDependencies {

    fun authLocalDataSource(): AuthLocalDataSource

    fun userRemoteDataSource(): UserRemoteDataSource

    fun feedPostRemoteDataSource(): FeedPostRemoteDataSource
}
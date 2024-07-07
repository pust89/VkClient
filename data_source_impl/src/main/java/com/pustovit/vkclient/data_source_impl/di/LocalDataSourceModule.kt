package com.pustovit.vkclient.data_source_impl.di

import com.pustovit.vkclient.data_source_impl.local.auth.AuthLocalDataSourceImpl
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:14
 */
@Module
internal interface LocalDataSourceModule {

    @Binds
    @FeatureScope
    fun bindsAuthLocalDataSource(source: AuthLocalDataSourceImpl): AuthLocalDataSource

}
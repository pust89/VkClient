package com.pustovit.vkclient.data_local_source_impl.di

import com.pustovit.vkclient.data_local_api.LocalDataSourceApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:22
 */
@FeatureScope
@Component(
    dependencies = [LocalDataSourceDependencies::class],
    modules = [LocalDataSourceModule::class]
)
interface LocalDataSourceComponent : LocalDataSourceApi
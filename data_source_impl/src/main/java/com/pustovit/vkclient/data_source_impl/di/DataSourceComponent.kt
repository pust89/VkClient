package com.pustovit.vkclient.data_source_impl.di

import com.pustovit.vkclient.data_source_api.DataSourceApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:22
 */
@FeatureScope
@Component(
    dependencies = [DataSourceDependencies::class],
    modules = [DataSourceModule::class]
)
interface DataSourceComponent : DataSourceApi
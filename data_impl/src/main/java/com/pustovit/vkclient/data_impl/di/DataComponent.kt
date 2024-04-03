package com.pustovit.vkclient.data_impl.di

import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:03
 */
@FeatureScope
@Component(
    dependencies = [DataDependencies::class],
    modules = [RepositoryModule::class]
)
interface DataComponent : DataApi
package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_impl.di.DaggerDataComponent
import com.pustovit.vkclient.data_impl.di.DataDependencies
import com.pustovit.vkclient.data_source_api.DataSourceApi
import com.pustovit.vkclient.data_source_impl.di.DaggerDataSourceComponent
import com.pustovit.vkclient.data_source_impl.di.DataSourceDependencies
import com.pustovit.vkclient.domain_api.DomainApi
import com.pustovit.vkclient.domain_impl.di.DaggerDomainComponent
import com.pustovit.vkclient.domain_impl.di.DomainDependencies
import com.pustovit.vkclient.navigation.ScreenNavigatorImpl
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:11
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideDataSourceApi(dependencies: DataSourceDependencies): DataSourceApi {
        return DaggerDataSourceComponent
            .builder()
            .dataSourceDependencies(dependencies)
            .build()
    }

    @Provides
    @Singleton
    fun provideDataApi(dependencies: DataDependencies): DataApi {
        return DaggerDataComponent
            .builder()
            .dataDependencies(dependencies)
            .build()
    }

    @Provides
    @Singleton
    fun provideDomainFeatureApi(dependencies: DomainDependencies): DomainApi {
        return DaggerDomainComponent
            .builder()
            .domainDependencies(dependencies)
            .build()
    }

    @Provides
    @Singleton
    fun provideScreenNavigator(): ScreenNavigator {
        return ScreenNavigatorImpl()
    }

}
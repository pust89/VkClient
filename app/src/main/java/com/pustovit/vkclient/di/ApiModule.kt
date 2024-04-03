package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_impl.di.DaggerDataComponent
import com.pustovit.vkclient.data_impl.di.DataDependencies
import com.pustovit.vkclient.data_local_api.LocalDataSourceApi
import com.pustovit.vkclient.data_local_source_impl.di.DaggerLocalDataSourceComponent
import com.pustovit.vkclient.data_local_source_impl.di.LocalDataSourceDependencies
//import com.pustovit.vkclient.data_local_api.LocalDataSourceApi
//import com.pustovit.vkclient.data_local_source_impl.di.DaggerLocalDataSourceComponent
//import com.pustovit.vkclient.data_local_source_impl.di.LocalDataSourceDependencies
import com.pustovit.vkclient.domain_api.news.DomainApi
import com.pustovit.vkclient.domain_impl.di.DaggerDomainComponent
import com.pustovit.vkclient.domain_impl.di.DomainDependencies
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
    fun provideLocalDataSourceApi(dependencies: LocalDataSourceDependencies): LocalDataSourceApi {
        return DaggerLocalDataSourceComponent
            .builder()
            .localDataSourceDependencies(dependencies)
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

}
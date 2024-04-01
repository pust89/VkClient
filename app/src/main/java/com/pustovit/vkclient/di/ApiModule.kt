package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataFeatureApi
import com.pustovit.vkclient.data_impl.di.DaggerDataComponent
import com.pustovit.vkclient.domain_api.news.DomainFeatureApi
import com.pustovit.vkclient.domain_impl.di.DaggerDomainComponent
import com.pustovit.vkclient.domain_impl.di.DomainDependencies
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import com.pustovit.vkclient.news_impl.di.DaggerNewsFeatureComponent
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.news_impl.di.NewsFeatureDependencies
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
    fun provideDataFeatureApi(): DataFeatureApi {
        return DaggerDataComponent.create()
    }

    @Provides
    @Singleton
    fun provideDomainFeatureApi(domainDependencies: DomainDependencies): DomainFeatureApi {
        return DaggerDomainComponent
            .builder()
            .domainDependencies(domainDependencies)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsFeatureApi(): NewsFeatureApi {
        return NewsFeatureComponentHolder.get()
    }
}
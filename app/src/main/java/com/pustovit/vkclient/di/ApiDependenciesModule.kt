package com.pustovit.vkclient.di

import com.pustovit.vkclient.data_api.DataFeatureApi
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.domain_impl.di.DomainDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:51
 */
@Module
class ApiDependenciesModule {
    @Provides
    @Singleton
    fun provideDomainDependencies(dataFeatureApi: DataFeatureApi): DomainDependencies {
        return object : DomainDependencies {
            override fun feedPostRepository(): FeedPostRepository {
                return dataFeatureApi.feedPostRepository()
            }
        }
    }
}
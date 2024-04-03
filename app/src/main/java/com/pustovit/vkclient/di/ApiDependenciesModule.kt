package com.pustovit.vkclient.di

import android.content.Context
import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_impl.di.DataDependencies
import com.pustovit.vkclient.data_local_api.LocalDataSourceApi
import com.pustovit.vkclient.data_local_api.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_local_source_impl.di.LocalDataSourceDependencies
//import com.pustovit.vkclient.data_local_source_impl.di.LocalDataSourceDependencies
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
    fun provideLocalDataSourceDependencies(context: Context): LocalDataSourceDependencies {
        return object : LocalDataSourceDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    @Singleton
    fun provideDataDependencies(localDataSourceApi: LocalDataSourceApi): DataDependencies {
        return object : DataDependencies {
            override fun authLocalDataSource(): AuthLocalDataSource {
                return localDataSourceApi.authLocalDataSource()
            }
        }
    }


    @Provides
    @Singleton
    fun provideDomainDependencies(dataApi: DataApi): DomainDependencies {
        return object : DomainDependencies {
            override fun feedPostRepository(): FeedPostRepository {
                return dataApi.feedPostRepository()
            }
        }
    }
}
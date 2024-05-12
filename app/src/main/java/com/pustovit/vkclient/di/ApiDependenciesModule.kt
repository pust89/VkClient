package com.pustovit.vkclient.di

import android.content.Context
import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_api.repository.UserRepository
import com.pustovit.vkclient.data_impl.di.DataDependencies
import com.pustovit.vkclient.data_source_api.DataSourceApi
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_source_impl.di.DataSourceDependencies
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
    fun provideDataSourceDependencies(context: Context): DataSourceDependencies {
        return object : DataSourceDependencies {
            override fun context(): Context {
                return context
            }
        }
    }

    @Provides
    @Singleton
    fun provideDataDependencies(dataSourceApi: DataSourceApi): DataDependencies {
        return object : DataDependencies {
            override fun authLocalDataSource(): AuthLocalDataSource {
                return dataSourceApi.authLocalDataSource()
            }
        }
    }

    @Provides
    @Singleton
    fun provideDomainDependencies(dataApi: DataApi): DomainDependencies {
        return object : DomainDependencies {

            override fun authRepository(): AuthRepository {
                return dataApi.authRepository()
            }

            override fun userRepository(): UserRepository {
                return dataApi.userRepository()
            }

            override fun feedPostRepository(): FeedPostRepository {
                return dataApi.feedPostRepository()
            }
        }
    }
}
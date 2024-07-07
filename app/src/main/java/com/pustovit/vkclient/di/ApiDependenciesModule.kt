package com.pustovit.vkclient.di

import android.content.Context
import androidx.core.os.BuildCompat
import com.pustovit.vkclient.data_api.DataApi
import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_api.repository.UserRepository
import com.pustovit.vkclient.data_impl.di.DataDependencies
import com.pustovit.vkclient.data_source_api.DataSourceApi
import com.pustovit.vkclient.models.build.BuildSettings
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.data_source_api.remote.UserRemoteDataSource
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
    fun provideBuildSettings(): BuildSettings {
        return object : BuildSettings {
            override val baseUrl: String
                get() = "https://api.vk.com/method/"
            override val apiVersion: String
                get() = "5.236"
            override val buildVariant: BuildSettings.BuildVariant
                get() = BuildSettings.BuildVariant.Debug//TODO сэтать из BuildConfig!
        }
    }

    @Provides
    @Singleton
    fun provideDataSourceDependencies(
        context: Context,
        buildSettings: BuildSettings
    ): DataSourceDependencies {
        return object : DataSourceDependencies {
            override fun context(): Context {
                return context
            }

            override fun buildSettings(): BuildSettings {
                return buildSettings
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

            override fun userRemoteDataSource(): UserRemoteDataSource {
                return dataSourceApi.userRemoteDataSource()
            }

            override fun feedPostRemoteDataSource(): FeedPostRemoteDataSource {
                return dataSourceApi.feedPostRemoteDataSource()
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
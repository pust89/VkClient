package com.pustovit.vkclient.data_source_impl.di

import com.pustovit.vkclient.models.build.BuildSettings
import com.pustovit.vkclient.data_source_api.local.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_source_impl.service.BaseAuthInterceptor
import com.pustovit.vkclient.injector.FeatureScope
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 18:18
 */
@Module
internal class ServiceModule {
    @Provides
    @FeatureScope
    fun providesBaseAuthInterceptor(
        authLocalDataSource: AuthLocalDataSource,
        buildSettings: BuildSettings,
    ): BaseAuthInterceptor {
        return BaseAuthInterceptor(
            authLocalDataSource = authLocalDataSource,
            buildSettings = buildSettings
        )
    }

    @Provides
    fun provideHttpLoggingInterceptor(buildSettings: BuildSettings): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (buildSettings.buildVariant == BuildSettings.BuildVariant.Release) {
                HttpLoggingInterceptor.Level.NONE
            } else {
                HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideOkHttpClient(
        baseAuthInterceptor: BaseAuthInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(timeout = 60L, unit = TimeUnit.SECONDS)
            connectTimeout(timeout = 60L, unit = TimeUnit.SECONDS)
            writeTimeout(timeout = 60L, unit = TimeUnit.SECONDS)
            addInterceptor(baseAuthInterceptor)
            addInterceptor(httpLoggingInterceptor)
        }.build()
    }

    @Provides
    @FeatureScope
    fun provideRetrofit(
        buildSettings: BuildSettings,
        moshi: Moshi,
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi).withNullSerialization())
            .baseUrl(buildSettings.baseUrl)
            .client(okHttpClient)
            .build()
    }
}
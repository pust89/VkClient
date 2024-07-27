package com.pustovit.vkclient.data_source_impl.di

import com.pustovit.vkclient.data_source_impl.remote.news.api.FeedPostApi
import com.pustovit.vkclient.data_source_impl.remote.user.api.UserApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Pustovit V.V.
 * Date: 01.06.2024
 * Time: 20:19
 */
@Module
internal class ApiModule {

    @Provides
    @FeatureScope
    fun providesUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @FeatureScope
    fun providesFeedPostApi(retrofit: Retrofit): FeedPostApi {
        return retrofit.create(FeedPostApi::class.java)
    }
}
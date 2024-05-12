package com.pustovit.vkclient.di

import com.pustovit.vkclient.auth_api.AuthFeatureApi
import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponentHolder
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.profile_api.ProfileFeatureApi
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponentHolder
import com.pustovit.vkclient.splash_api.SplashFeatureApi
import com.pustovit.vkclient.splash_impl.di.SplashFeatureComponentHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:38
 */
@Module
class FeatureApiModule {

    @Provides
    @Singleton
    fun provideSplashFeatureApi(): SplashFeatureApi {
        return SplashFeatureComponentHolder.get()
    }

    @Provides
    @Singleton
    fun provideAuthFeatureApi(): AuthFeatureApi {
        return AuthFeatureComponentHolder.get()
    }

    @Provides
    @Singleton
    fun provideProfileFeatureApi(): ProfileFeatureApi {
        return ProfileFeatureComponentHolder.get()
    }

    @Provides
    @Singleton
    fun provideNewsFeatureApi(): NewsFeatureApi {
        return NewsFeatureComponentHolder.get()
    }

}
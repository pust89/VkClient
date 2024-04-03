package com.pustovit.vkclient.di

import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
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
    fun provideNewsFeatureApi(): NewsFeatureApi {
        return NewsFeatureComponentHolder.get()
    }
}
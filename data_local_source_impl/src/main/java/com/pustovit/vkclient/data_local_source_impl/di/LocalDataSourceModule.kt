package com.pustovit.vkclient.data_local_source_impl.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.pustovit.vkclient.data_local_api.auth.AuthLocalDataSource
import com.pustovit.vkclient.data_local_source_impl.auth.AuthLocalDataSourceImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 03.04.2024
 * Time: 22:14
 */
@Module
internal class LocalDataSourceModule {
    @FeatureScope
    @Provides
    fun provideSharePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
    }

    @FeatureScope
    @Provides
    fun provideAuthLocalDataSource(sharedPreferences: SharedPreferences): AuthLocalDataSource{
        return AuthLocalDataSourceImpl(sharedPreferences)
    }

    private companion object {
        const val PREFERENCES_NAME = "com.pustovit.vkclient.data_local_source_impl.di"
    }
}
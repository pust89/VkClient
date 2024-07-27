package com.pustovit.vkclient.data_source_impl.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:17
 */
@Module
internal class SharedPrefModule {

    @Provides
    @FeatureScope
    fun provideSharePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @FeatureScope
    fun provideGson(): Gson {
        return Gson()
    }

    private companion object {
        const val PREFERENCES_NAME = "com.pustovit.vkclient.data_local_source_impl.di"
    }
}
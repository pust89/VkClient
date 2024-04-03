package com.pustovit.vkclient.di

import android.content.Context
import com.pustovit.vkclient.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:07
 */

@Singleton
@Component(
    modules = [
        ApiDependenciesModule::class,
        ApiModule::class,
        FeatureApiModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder
        fun build(): AppComponent
    }

}
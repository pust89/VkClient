package com.pustovit.vkclient.splash_impl.di

import com.pustovit.vkclient.injector.ComponentHolder
import com.pustovit.vkclient.injector.ComponentHolderDelegate
import com.pustovit.vkclient.splash_api.SplashFeatureApi

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 22:18
 */
object SplashFeatureComponentHolder : ComponentHolder<SplashFeatureApi, SplashFeatureDependencies> {
    override var dependencyProvider: (() -> SplashFeatureDependencies)? = null

    internal val component by ComponentHolderDelegate<SplashFeatureDependencies,
            SplashFeatureComponent> { dependencies ->
        DaggerSplashFeatureComponent.builder()
            .splashFeatureDependencies(dependencies)
            .build()
    }

    override fun get(): SplashFeatureApi {
        return component
    }
}
package com.pustovit.vkclient.profile_impl.di

import com.pustovit.vkclient.injector.ComponentHolder
import com.pustovit.vkclient.injector.ComponentHolderDelegate
import com.pustovit.vkclient.profile_api.ProfileFeatureApi

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:31
 */
object ProfileFeatureComponentHolder :
    ComponentHolder<ProfileFeatureApi, ProfileFeatureDependencies> {

    override var dependencyProvider: (() -> ProfileFeatureDependencies)? = null
    internal val component: ProfileFeatureComponent by ComponentHolderDelegate<ProfileFeatureDependencies,
            ProfileFeatureComponent> { dependencies ->
        DaggerProfileFeatureComponent.builder()
            .profileFeatureDependencies(dependencies)
            .build()
    }

    override fun get(): ProfileFeatureApi {
        return component
    }
}
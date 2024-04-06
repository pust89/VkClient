package com.pustovit.vkclient.auth_impl.di

import com.pustovit.vkclient.auth_api.AuthFeatureApi
import com.pustovit.vkclient.injector.ComponentHolder
import com.pustovit.vkclient.injector.ComponentHolderDelegate


/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 20:07
 */
object AuthFeatureComponentHolder : ComponentHolder<AuthFeatureApi, AuthFeatureDependencies> {

    override var dependencyProvider: (() -> AuthFeatureDependencies)? = null
    internal val component: AuthFeatureComponent by ComponentHolderDelegate<AuthFeatureDependencies,
            AuthFeatureComponent> { dependencies ->
        DaggerAuthFeatureComponent.builder()
            .authFeatureDependencies(dependencies)
            .build()
    }

    override fun get(): AuthFeatureApi {
        return component
    }
}
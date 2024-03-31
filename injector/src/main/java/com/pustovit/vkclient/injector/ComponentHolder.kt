package com.pustovit.vkclient.injector

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:30
 */
interface ComponentHolder<A : FeatureApi, D : FeatureDependencies> {

    var dependencyProvider: (() -> D)?

    fun get(): A

}
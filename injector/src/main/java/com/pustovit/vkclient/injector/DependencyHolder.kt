package com.pustovit.vkclient.injector

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:26
 */
interface DependencyHolder<D : FeatureDependencies> {
    val dependencies: D
}
package com.pustovit.vkclient.injector

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:26
 */
interface FeatureDependencies {
    val dependencyHolder: DependencyHolder<out FeatureDependencies>
}
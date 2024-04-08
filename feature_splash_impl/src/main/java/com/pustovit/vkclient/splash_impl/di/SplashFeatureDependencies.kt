package com.pustovit.vkclient.splash_impl.di

import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.injector.FeatureDependencies

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 22:13
 */
interface SplashFeatureDependencies : FeatureDependencies {
    fun getVkAccessTokenUseCase(): GetVkAccessTokenUseCase
}
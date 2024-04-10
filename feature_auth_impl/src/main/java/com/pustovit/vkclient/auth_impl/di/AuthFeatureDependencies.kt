package com.pustovit.vkclient.auth_impl.di

import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.screens.core.ScreenNavigator

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 20:05
 */
interface AuthFeatureDependencies:FeatureDependencies {

    fun saveVkAccessTokenUseCase():SaveVkAccessTokenUseCase

     val screenNavigator: ScreenNavigator

}
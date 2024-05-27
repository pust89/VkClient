package com.pustovit.vkclient.profile_impl.di

import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.screens.navigation.ScreenNavigator

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:31
 */
interface ProfileFeatureDependencies : FeatureDependencies {

    val screenNavigator: ScreenNavigator

    fun getCurrentUserUseCase(): GetCurrentUserUseCase

    fun getLogoutUseCase(): LogoutUseCase

}
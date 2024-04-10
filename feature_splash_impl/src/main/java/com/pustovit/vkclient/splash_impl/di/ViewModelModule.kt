package com.pustovit.vkclient.splash_impl.di

import com.pustovit.vkclient.splash_impl.presentation.SplashViewModel
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.screens.core.ScreenNavigator
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 22:14
 */
@Module
class ViewModelModule {

    @FeatureScope
    @Provides
    fun provideFactory(
        getVkAccessTokenUseCase: GetVkAccessTokenUseCase,
        screenNavigator: ScreenNavigator
    ) = SplashViewModel.Factory(
        getVkAccessTokenUseCase = getVkAccessTokenUseCase,
        screenNavigator = screenNavigator
    )
}
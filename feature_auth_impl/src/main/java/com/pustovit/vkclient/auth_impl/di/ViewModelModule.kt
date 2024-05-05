package com.pustovit.vkclient.auth_impl.di

import com.pustovit.vkclient.auth_impl.presentation.AuthViewModel
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 20:00
 */
@Module
class ViewModelModule {

    @Provides
    @FeatureScope
    fun provideAuthViewModelFactory(
        saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase,
        screenNavigator: ScreenNavigator
    ): AuthViewModel.Factory {
        return AuthViewModel.Factory(
            saveVkAccessTokenUseCase = saveVkAccessTokenUseCase,
            screenNavigator = screenNavigator
        )
    }

}
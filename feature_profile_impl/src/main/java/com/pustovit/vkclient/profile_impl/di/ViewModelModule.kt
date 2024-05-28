package com.pustovit.vkclient.profile_impl.di

import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.profile_impl.presentation.profile.ProfileViewModel
import com.pustovit.vkclient.profile_impl.presentation.settings.UserSettingsViewModel
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:31
 */
@Module
class ViewModelModule {

    @Provides
    @FeatureScope
    fun provideProfileViewModelFactory(
        screenNavigator: ScreenNavigator,
        getCurrentUserUseCase: GetCurrentUserUseCase,
    ): ProfileViewModel.Factory {
        return ProfileViewModel.Factory(
            screenNavigator = screenNavigator,
            getCurrentUserUseCase = getCurrentUserUseCase,
        )
    }

    @Provides
    @FeatureScope
    fun provideUserSettingsViewModelFactory(
        screenNavigator: ScreenNavigator,
        logoutUseCase: LogoutUseCase,
    ): UserSettingsViewModel.Factory {
        return UserSettingsViewModel.Factory(
            screenNavigator = screenNavigator,
            logoutUseCase = logoutUseCase,
        )
    }

}
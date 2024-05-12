package com.pustovit.vkclient.profile_impl.di

import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.profile_impl.presentation.ProfileViewModel
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

}
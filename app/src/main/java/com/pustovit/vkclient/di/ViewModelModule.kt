package com.pustovit.vkclient.di

import com.pustovit.vkclient.MainViewModel
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:48
 */
@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideMainViewModelFactory(screenNavigator: ScreenNavigator): MainViewModel.Factory {
        return MainViewModel.Factory(
            screenNavigator = screenNavigator
        )
    }
}
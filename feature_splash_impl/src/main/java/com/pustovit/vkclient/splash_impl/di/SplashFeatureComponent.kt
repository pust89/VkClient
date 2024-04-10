package com.pustovit.vkclient.splash_impl.di

import androidx.compose.runtime.Composable
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.splash_api.SplashFeatureApi
import com.pustovit.vkclient.splash_impl.presentation.SplashViewModel
import dagger.BindsInstance
import dagger.Component


/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 22:16
 */
@Component(
    dependencies = [SplashFeatureDependencies::class],
    modules = [ViewModelModule::class]
)
@FeatureScope
interface SplashFeatureComponent : SplashFeatureApi {

    fun splashViewModelFactory(): SplashViewModel.Factory

}
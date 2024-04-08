package com.pustovit.vkclient.auth_impl.di

import com.pustovit.vkclient.auth_api.AuthFeatureApi
import com.pustovit.vkclient.auth_impl.presentation.AuthViewModel
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:59
 */
@FeatureScope
@Component(
    dependencies = [AuthFeatureDependencies::class],
    modules = [ViewModelModule::class]
)
internal interface AuthFeatureComponent : AuthFeatureApi {

    fun authViewModelFactory(): AuthViewModel.Factory

}
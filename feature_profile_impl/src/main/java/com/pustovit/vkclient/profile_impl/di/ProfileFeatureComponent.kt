package com.pustovit.vkclient.profile_impl.di

import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.profile_api.ProfileFeatureApi
import com.pustovit.vkclient.profile_impl.presentation.ProfileViewModel
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:31
 */

@FeatureScope
@Component(
    dependencies = [ProfileFeatureDependencies::class],
    modules = [ViewModelModule::class]
)
internal interface ProfileFeatureComponent : ProfileFeatureApi {

    fun profileViewModelFactory(): ProfileViewModel.Factory

}
package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.domain_impl.user.GetCurrentUserUseCaseImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:26
 */
@Module
internal interface UserUseCaseModule {

    @Binds
    @FeatureScope
    fun bindGetCurrentUserUseCase(useCase: GetCurrentUserUseCaseImpl): GetCurrentUserUseCase
}
package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_impl.auth.GetVkAccessTokenUseCaseImpl
import com.pustovit.vkclient.domain_impl.auth.LogoutUseCaseImpl
import com.pustovit.vkclient.domain_impl.auth.SaveVkAccessTokenUseCaseImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:37
 */

@Module
internal interface AuthUseCaseModule {

    @Binds
    @FeatureScope
    fun bindSaveVkAccessTokenUseCase(useCase: SaveVkAccessTokenUseCaseImpl): SaveVkAccessTokenUseCase

    @Binds
    @FeatureScope
    fun bindGetVkAccessTokenUseCase(useCase: GetVkAccessTokenUseCaseImpl): GetVkAccessTokenUseCase

    @Binds
    @FeatureScope
    fun bindLogoutUseCase(useCase: LogoutUseCaseImpl): LogoutUseCase
}
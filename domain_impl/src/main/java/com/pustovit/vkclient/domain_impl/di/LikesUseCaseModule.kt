package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import com.pustovit.vkclient.domain_impl.likes.AddLikeUseCaseImpl
import com.pustovit.vkclient.domain_impl.likes.DeleteLikeUseCaseImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:49
 */
@Module
internal interface LikesUseCaseModule {

    @Binds
    @FeatureScope
    fun bindAddLikeUseCase(useCase: AddLikeUseCaseImpl): AddLikeUseCase

    @Binds
    @FeatureScope
    fun bindDeleteLikeUseCase(useCase: DeleteLikeUseCaseImpl): DeleteLikeUseCase
}
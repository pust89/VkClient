package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.domain_impl.news.GetAllPostsUseCaseImpl
import com.pustovit.vkclient.domain_impl.news.RemovePostUseCaseImpl
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Binds
import dagger.Module

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:10
 */
@Module
internal interface UseCaseModule {
    @Binds
    @FeatureScope
    fun bindGetAllPostsUseCase(useCase: GetAllPostsUseCaseImpl): GetAllPostsUseCase
    @Binds
    @FeatureScope
    fun bindRemovePostUseCase(useCase: RemovePostUseCaseImpl): RemovePostUseCase
}
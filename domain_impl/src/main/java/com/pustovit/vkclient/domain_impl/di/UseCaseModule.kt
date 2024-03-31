package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_impl.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_impl.news.GetAllPostsUseCaseImpl
import com.pustovit.vkclient.domain_impl.news.RemovePostUseCase
import com.pustovit.vkclient.domain_impl.news.RemovePostUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:10
 */
@Module
internal interface UseCaseModule {
    @Binds
    @Singleton
    fun bindGetAllPostsUseCase(useCase: GetAllPostsUseCaseImpl): GetAllPostsUseCase
    @Binds
    @Singleton
    fun bindGetAllPostsUseCase(useCase: RemovePostUseCaseImpl): RemovePostUseCase
}
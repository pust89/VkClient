package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.data_impl.di.DataComponent
import com.pustovit.vkclient.domain_impl.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_impl.news.RemovePostUseCase
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:10
 */
@Singleton
@Component(
    modules = [UseCaseModule::class],
    dependencies = [DataComponent::class]
)
interface DomainComponent {
    fun getAllPostsUseCase(): GetAllPostsUseCase
    fun removePostUseCase(): RemovePostUseCase
}
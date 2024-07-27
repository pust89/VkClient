package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.DomainApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:10
 */
@FeatureScope
@Component(
    dependencies = [DomainDependencies::class],
    modules = [
        AuthUseCaseModule::class,
        UserUseCaseModule::class,
        NewsUseCaseModule::class,
        LikesUseCaseModule::class,
    ],
)
interface DomainComponent : DomainApi
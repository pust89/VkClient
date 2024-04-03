package com.pustovit.vkclient.domain_impl.di

import com.pustovit.vkclient.domain_api.news.DomainApi
import com.pustovit.vkclient.injector.FeatureScope
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:10
 */
@FeatureScope
@Component(
    modules = [UseCaseModule::class],
    dependencies = [DomainDependencies::class]
)
interface DomainComponent : DomainApi
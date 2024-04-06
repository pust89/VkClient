package com.pustovit.vkclient.di

import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponentHolder
import com.pustovit.vkclient.auth_impl.di.AuthFeatureDependencies
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.DependencyHolder
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.news_impl.di.NewsFeatureDependencies

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 22:15
 */
internal fun setFeatureDependencies(allApi: AllApi) {
    setAuthFeatureDependencies(allApi)
    setNewsFeatureDependencies(allApi)
}

private fun setNewsFeatureDependencies(allApi: AllApi) {
    class NewsFeatureDependenciesHolder : DependencyHolder<NewsFeatureDependencies> {
        override val dependencies: NewsFeatureDependencies
            get() = object : NewsFeatureDependencies {
                override fun getAllPostsUseCase(): GetAllPostsUseCase {
                    return allApi.domainApi.getAllPostsUseCase()
                }

                override fun removePostUseCase(): RemovePostUseCase {
                    return allApi.domainApi.removePostUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@NewsFeatureDependenciesHolder
            }
    }

    NewsFeatureComponentHolder.dependencyProvider = {
        NewsFeatureDependenciesHolder().dependencies
    }
}

private fun setAuthFeatureDependencies(allApi: AllApi) {
    class AuthFeatureDependenciesHolder : DependencyHolder<AuthFeatureDependencies> {
        override val dependencies: AuthFeatureDependencies
            get() = object : AuthFeatureDependencies {
                override fun saveVkAccessTokenUseCase(): SaveVkAccessTokenUseCase {
                    return allApi.domainApi.saveVkAccessTokenUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@AuthFeatureDependenciesHolder
            }
    }

    AuthFeatureComponentHolder.dependencyProvider = {
        AuthFeatureDependenciesHolder().dependencies
    }
}
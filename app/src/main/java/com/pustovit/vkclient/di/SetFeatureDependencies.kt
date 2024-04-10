package com.pustovit.vkclient.di

import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponentHolder
import com.pustovit.vkclient.auth_impl.di.AuthFeatureDependencies
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.DependencyHolder
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.news_impl.di.NewsFeatureDependencies
import com.pustovit.vkclient.screens.core.ScreenNavigator
import com.pustovit.vkclient.splash_impl.di.SplashFeatureComponentHolder
import com.pustovit.vkclient.splash_impl.di.SplashFeatureDependencies

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 22:15
 */
internal fun setFeatureDependencies(allApi: AllApi) {
    setAuthFeatureDependencies(allApi)
    setNewsFeatureDependencies(allApi)
    setSplashFeatureDependencies(allApi)
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

private fun setSplashFeatureDependencies(allApi: AllApi) {
    class SplashFeatureDependenciesHolder : DependencyHolder<SplashFeatureDependencies> {
        override val dependencies: SplashFeatureDependencies
            get() = object : SplashFeatureDependencies {
                override fun getVkAccessTokenUseCase(): GetVkAccessTokenUseCase {
                    return allApi.domainApi.getVkAccessTokenUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@SplashFeatureDependenciesHolder

                override fun getScreenNavigator(): ScreenNavigator {
                    return allApi.screenNavigator
                }
            }
    }
    SplashFeatureComponentHolder.dependencyProvider = {
        SplashFeatureDependenciesHolder().dependencies
    }
}
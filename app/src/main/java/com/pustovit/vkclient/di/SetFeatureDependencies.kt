package com.pustovit.vkclient.di

import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponentHolder
import com.pustovit.vkclient.auth_impl.di.AuthFeatureDependencies
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import com.pustovit.vkclient.domain_api.news.FeedPostPageSource
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.injector.DependencyHolder
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.news_impl.di.NewsFeatureDependencies
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponentHolder
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureDependencies
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.splash_impl.di.SplashFeatureComponentHolder
import com.pustovit.vkclient.splash_impl.di.SplashFeatureDependencies

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 22:15
 */
internal fun setFeatureDependencies(allApi: AllApi) {
    setSplashFeatureDependencies(allApi)
    setAuthFeatureDependencies(allApi)
    setProfileFeatureDependencies(allApi)
    setNewsFeatureDependencies(allApi)
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

private fun setAuthFeatureDependencies(allApi: AllApi) {
    class AuthFeatureDependenciesHolder : DependencyHolder<AuthFeatureDependencies> {
        override val dependencies: AuthFeatureDependencies
            get() = object : AuthFeatureDependencies {
                override fun saveVkAccessTokenUseCase(): SaveVkAccessTokenUseCase {
                    return allApi.domainApi.saveVkAccessTokenUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@AuthFeatureDependenciesHolder

                override val screenNavigator: ScreenNavigator = allApi.screenNavigator
            }
    }

    AuthFeatureComponentHolder.dependencyProvider = {
        AuthFeatureDependenciesHolder().dependencies
    }
}

private fun setProfileFeatureDependencies(allApi: AllApi) {
    class ProfileFeatureDependenciesHolder : DependencyHolder<ProfileFeatureDependencies> {
        override val dependencies: ProfileFeatureDependencies
            get() = object : ProfileFeatureDependencies {

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@ProfileFeatureDependenciesHolder

                override val screenNavigator: ScreenNavigator = allApi.screenNavigator

                override fun getCurrentUserUseCase(): GetCurrentUserUseCase {
                    return allApi.domainApi.getCurrentUserUseCase()
                }

                override fun getLogoutUseCase(): LogoutUseCase {
                    return allApi.domainApi.logoutUseCase()
                }
            }
    }

    ProfileFeatureComponentHolder.dependencyProvider = {
        ProfileFeatureDependenciesHolder().dependencies
    }
}


private fun setNewsFeatureDependencies(allApi: AllApi) {
    class NewsFeatureDependenciesHolder : DependencyHolder<NewsFeatureDependencies> {
        override val dependencies: NewsFeatureDependencies
            get() = object : NewsFeatureDependencies {

                override fun feedPostPageSource(): FeedPostPageSource {
                    return allApi.domainApi.feedPostPageSource()
                }

                override fun removePostUseCase(): RemovePostUseCase {
                    return allApi.domainApi.removePostUseCase()
                }

                override fun getScreenNavigator(): ScreenNavigator {
                    return allApi.screenNavigator
                }

                override fun addLikeUseCase(): AddLikeUseCase {
                    return allApi.domainApi.addLikeUseCase()
                }

                override fun deleteLikeUseCase(): DeleteLikeUseCase {
                    return allApi.domainApi.deleteLikeUseCase()
                }

                override val dependencyHolder: DependencyHolder<out FeatureDependencies>
                    get() = this@NewsFeatureDependenciesHolder
            }
    }

    NewsFeatureComponentHolder.dependencyProvider = {
        NewsFeatureDependenciesHolder().dependencies
    }
}

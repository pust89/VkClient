package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.domain_api.news.GetFeedPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.FeatureDependencies
import com.pustovit.vkclient.screens.navigation.ScreenNavigator

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:40
 */
interface NewsFeatureDependencies : FeatureDependencies {

    fun getAllPostsUseCase(): GetFeedPostsUseCase

    fun removePostUseCase(): RemovePostUseCase

    fun getScreenNavigator(): ScreenNavigator

}
package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.domain_api.news.GetFeedPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsFeedViewModel
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import dagger.Module
import dagger.Provides

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:27
 */
@Module
internal class ViewModelModule {

    @FeatureScope
    @Provides
    fun provideFactory(
        screenNavigator: ScreenNavigator,
        getFeedPostsUseCase: GetFeedPostsUseCase,
        removePostUseCase: RemovePostUseCase,
    ) = NewsFeedViewModel.Factory(
        screenNavigator = screenNavigator,
        getFeedPostsUseCase = getFeedPostsUseCase,
        removePostUseCase = removePostUseCase,
    )
}
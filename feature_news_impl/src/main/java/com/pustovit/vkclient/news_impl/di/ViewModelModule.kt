package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import com.pustovit.vkclient.domain_api.news.GetRecommendedFeedPostsUseCase
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
        getRecommendedFeedPostsUseCase: GetRecommendedFeedPostsUseCase,
        removePostUseCase: RemovePostUseCase,
        addLikeUseCase: AddLikeUseCase,
        deleteLikeUseCase: DeleteLikeUseCase,
    ) = NewsFeedViewModel.Factory(
        screenNavigator = screenNavigator,
        getRecommendedFeedPostsUseCase = getRecommendedFeedPostsUseCase,
        removePostUseCase = removePostUseCase,
        addLikeUseCase = addLikeUseCase,
        deleteLikeUseCase = deleteLikeUseCase,
    )
}
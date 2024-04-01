package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsFeedViewModel
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
        getAllPostsUseCase: GetAllPostsUseCase,
        removePostUseCase: RemovePostUseCase
    ) = NewsFeedViewModel.Factory(
        getAllPostsUseCase = getAllPostsUseCase,
        removePostUseCase = removePostUseCase,
    )
}
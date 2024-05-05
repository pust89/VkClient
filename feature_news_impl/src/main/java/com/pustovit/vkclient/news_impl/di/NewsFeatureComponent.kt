package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsFeedViewModel
import com.pustovit.vkclient.screens.core.ScreenNavigator
import dagger.Component

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:57
 */
@FeatureScope
@Component(
    dependencies = [NewsFeatureDependencies::class],
    modules = [ViewModelModule::class]
)
internal interface NewsFeatureComponent : NewsFeatureApi {
    val newsFeedViewModelFactory: NewsFeedViewModel.Factory
    val screenNavigator: ScreenNavigator
}

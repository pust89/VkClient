package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.injector.ComponentHolder
import com.pustovit.vkclient.injector.ComponentHolderDelegate
import com.pustovit.vkclient.injector.FeatureScope
import com.pustovit.vkclient.news_api.screens.CommentsScreen
import com.pustovit.vkclient.news_api.screens.NewsApi
import com.pustovit.vkclient.news_api.screens.NewsScreen
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
class NewsComponent : NewsApi {

//    override fun newsFeedScreen(): NewsScreen {
//
//    }
//
//    override fun commentScreen(args: CommentsScreen.Args): CommentsScreen {
//    }
}

object NewsComponentHolder : ComponentHolder<NewsApi, NewsFeatureDependencies> {

    override var dependencyProvider: (() -> NewsFeatureDependencies)? = null

    internal val component: NewsComponent by
    ComponentHolderDelegate<NewsFeatureDependencies, NewsComponent> {
//        DaggerNewsComponent.builder().eventFeatureDependencies(it).build()
        NewsComponent()
    }

    override fun get(): NewsApi {
        return component
    }

}
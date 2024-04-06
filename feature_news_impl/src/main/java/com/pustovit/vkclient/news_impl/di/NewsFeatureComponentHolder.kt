package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.injector.ComponentHolder
import com.pustovit.vkclient.injector.ComponentHolderDelegate
import com.pustovit.vkclient.news_api.screens.NewsFeatureApi

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 22:28
 */
object NewsFeatureComponentHolder : ComponentHolder<NewsFeatureApi, NewsFeatureDependencies> {

    override var dependencyProvider: (() -> NewsFeatureDependencies)? = null

    internal val component: NewsFeatureComponent by ComponentHolderDelegate<NewsFeatureDependencies,
            NewsFeatureComponent> { dependencies ->
        DaggerNewsFeatureComponent.builder().newsFeatureDependencies(dependencies)
            .build()
    }

    override fun get(): NewsFeatureApi {
        return component
    }
}
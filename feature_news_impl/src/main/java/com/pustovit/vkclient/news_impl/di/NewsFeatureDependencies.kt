package com.pustovit.vkclient.news_impl.di

import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.injector.FeatureDependencies

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 12:40
 */
interface NewsFeatureDependencies : FeatureDependencies {
    fun getAllPostsUseCase(): GetAllPostsUseCase
    fun removePostUseCase(): RemovePostUseCase
}
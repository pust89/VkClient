package com.pustovit.vkclient.domain_api.news

import com.pustovit.vkclient.injector.FeatureApi

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:08
 */
interface DomainFeatureApi : FeatureApi {
    fun getAllPostsUseCase(): GetAllPostsUseCase
    fun removePostUseCase(): RemovePostUseCase
}
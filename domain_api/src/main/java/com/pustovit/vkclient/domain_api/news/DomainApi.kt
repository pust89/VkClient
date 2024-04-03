package com.pustovit.vkclient.domain_api.news

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:08
 */
interface DomainApi {
    fun getAllPostsUseCase(): GetAllPostsUseCase
    fun removePostUseCase(): RemovePostUseCase
}
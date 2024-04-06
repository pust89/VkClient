package com.pustovit.vkclient.domain_api

import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:08
 */
interface DomainApi {
    fun getAllPostsUseCase(): GetAllPostsUseCase
    fun removePostUseCase(): RemovePostUseCase
    fun getVkAccessTokenUseCase(): GetVkAccessTokenUseCase
    fun saveVkAccessTokenUseCase(): SaveVkAccessTokenUseCase
}
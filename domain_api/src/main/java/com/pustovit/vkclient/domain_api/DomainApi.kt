package com.pustovit.vkclient.domain_api

import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import com.pustovit.vkclient.domain_api.news.FeedPostPageSource
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 20:08
 */
interface DomainApi {

    fun getVkAccessTokenUseCase(): GetVkAccessTokenUseCase

    fun saveVkAccessTokenUseCase(): SaveVkAccessTokenUseCase

    fun logoutUseCase(): LogoutUseCase

    fun getCurrentUserUseCase(): GetCurrentUserUseCase


    fun removePostUseCase(): RemovePostUseCase

    fun addLikeUseCase(): AddLikeUseCase

    fun deleteLikeUseCase(): DeleteLikeUseCase

    fun feedPostPageSource(): FeedPostPageSource
}
package com.pustovit.vkclient.data_api

import com.pustovit.vkclient.data_api.repository.AuthRepository
import com.pustovit.vkclient.data_api.repository.FeedPostRepository

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:48
 */
interface DataApi {

    fun feedPostRepository(): FeedPostRepository

    fun authRepository(): AuthRepository
}
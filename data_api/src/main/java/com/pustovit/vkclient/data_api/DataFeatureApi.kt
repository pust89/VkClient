package com.pustovit.vkclient.data_api

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.injector.FeatureApi

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:48
 */
interface DataFeatureApi : FeatureApi {

    fun feedPostRepository(): FeedPostRepository
}
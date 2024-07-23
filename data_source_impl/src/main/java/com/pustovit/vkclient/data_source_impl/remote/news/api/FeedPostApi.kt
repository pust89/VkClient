package com.pustovit.vkclient.data_source_impl.remote.news.api

import com.pustovit.vkclient.data_source_impl.remote.base.VkResponse
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostResponseDto
import retrofit2.http.GET

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:07
 */
interface FeedPostApi {

    @GET("newsfeed.get?filters=post,photo")
    suspend fun getFeedPosts(): VkResponse<FeedPostResponseDto>
}
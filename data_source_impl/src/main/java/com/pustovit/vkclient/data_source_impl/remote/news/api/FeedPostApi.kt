package com.pustovit.vkclient.data_source_impl.remote.news.api

import com.pustovit.vkclient.data_source_impl.remote.base.VkResponse
import com.pustovit.vkclient.data_source_impl.remote.news.model.FeedPostContentDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:07
 */
internal interface FeedPostApi {

    @GET("newsfeed.get?count=10")
    suspend fun getFeedPosts(
        @Query("start_from") startFrom: String?
    ): VkResponse<FeedPostContentDto>

}
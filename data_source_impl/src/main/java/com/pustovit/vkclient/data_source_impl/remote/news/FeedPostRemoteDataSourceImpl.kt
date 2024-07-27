package com.pustovit.vkclient.data_source_impl.remote.news

import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.data_source_impl.remote.base.process
import com.pustovit.vkclient.data_source_impl.remote.news.api.FeedPostApi
import com.pustovit.vkclient.data_source_impl.remote.news.mapper.FeedPostMapper
import com.pustovit.vkclient.models.post.FeedPost
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 18:06
 */
internal class FeedPostRemoteDataSourceImpl @Inject constructor(
    private val api: FeedPostApi,
    private val mapper: FeedPostMapper,
) : FeedPostRemoteDataSource {

    override suspend fun getRecommendedFeedPosts(startFrom: String?): List<FeedPost> {
        return api.getRecommendedFeedPosts(startFrom).process(mapper::map)
    }
}
package com.pustovit.vkclient.data_source_impl.remote.news

import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.data_source_impl.remote.base.process
import com.pustovit.vkclient.data_source_impl.remote.news.api.FeedPostApi
import com.pustovit.vkclient.data_source_impl.remote.news.mapper.FeedPostMapper
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.Page
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

    override suspend fun getFeedPosts(startFrom: String?): Page<FeedPost> {
        return api.getFeedPosts(startFrom).process(mapper::map)
    }
}
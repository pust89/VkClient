package com.pustovit.vkclient.domain_api.news

import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 16:28
 */
interface FeedPostPageSource {

    fun getFeedPosts(): Flow<List<FeedPost>>

    suspend fun loadFirst()

    suspend fun loadNext()
}
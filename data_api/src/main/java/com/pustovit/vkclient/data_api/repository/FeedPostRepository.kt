package com.pustovit.vkclient.data_api.repository

import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 13:43
 */

interface FeedPostRepository {
    fun getRecommendedFeedPosts(): Flow<List<FeedPost>>
    fun remove(feedPost: FeedPost): Flow<Boolean>
}
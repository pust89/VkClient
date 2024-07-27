package com.pustovit.vkclient.domain_api.news

import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 9:46
 */
interface GetRecommendedFeedPostsUseCase {
    operator fun invoke(startFrom: String? = null): Flow<List<FeedPost>>
}
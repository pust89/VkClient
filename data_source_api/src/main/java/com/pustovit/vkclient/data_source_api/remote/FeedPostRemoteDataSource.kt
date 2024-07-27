package com.pustovit.vkclient.data_source_api.remote

import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.Page

/**
 * Created by Pustovit V.V.
 * Date: 07.07.2024
 * Time: 16:06
 */
interface FeedPostRemoteDataSource {

    suspend fun getFeedPosts(startFrom: String?): Page<FeedPost>
}
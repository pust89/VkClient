package com.pustovit.vkclient.data_impl.repository.news

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.data_source_api.remote.FeedPostRemoteDataSource
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 16:20
 */
internal class FeedPostRepositoryImpl @Inject constructor(
    private val feedPostRemoteDataSource: FeedPostRemoteDataSource,
) : FeedPostRepository {


    override fun getFeedPosts(startFrom: String?): Flow<List<FeedPost>> = flow {
        emit(feedPostRemoteDataSource.getFeedPosts(startFrom))
    }.flowOn(Dispatchers.IO)

    override fun remove(feedPost: FeedPost): Flow<Boolean> = flow {
        emit(true)
    }.flowOn(Dispatchers.IO)

}

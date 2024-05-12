package com.pustovit.vkclient.data_impl.repository.news

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 16:20
 */
internal class FeedPostRepositoryImpl @Inject constructor() : FeedPostRepository {

    private val mock = mutableListOf<FeedPost>().apply {
        repeat(5) {
            this += FeedPost(id = it)
        }
    }

    override fun getAll(): Flow<List<FeedPost>> = flow {
        delay(1500)
        emit(mock.toList())
    }.flowOn(Dispatchers.IO)

    override fun remove(feedPost: FeedPost): Flow<Boolean> = flow {
        emit(mock.remove(feedPost))
    }.flowOn(Dispatchers.IO)

}

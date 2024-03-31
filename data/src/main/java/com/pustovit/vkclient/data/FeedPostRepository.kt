package com.pustovit.vkclient.data

import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 16:20
 */
internal object FeedPostRepositoryImpl : FeedPostRepository {

    private val mock = mutableListOf<FeedPost>().apply {
        repeat(5) {
            this += FeedPost(id = it)
        }
    }

    override fun getAll(): Flow<List<FeedPost>> {
        return flow {
            delay(3000)
            emit(mock.toList())
        }.flowOn(Dispatchers.IO)
    }

    override fun remove(feedPost: FeedPost): Flow<Boolean> {
        return flow {
            emit(mock.remove(feedPost))
        }.flowOn(Dispatchers.IO)
    }
}

interface FeedPostRepository {
    fun getAll(): Flow<List<FeedPost>>
    fun remove(feedPost: FeedPost): Flow<Boolean>
}
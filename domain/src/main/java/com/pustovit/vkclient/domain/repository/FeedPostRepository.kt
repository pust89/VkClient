package com.pustovit.vkclient.domain.repository

import com.pustovit.vkclient.domain.model.FeedPost
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
object FeedPostRepository {

    private val mock = mutableListOf<FeedPost>().apply {
        repeat(5) {
            this += FeedPost(id = it)
        }
    }

    fun getAll(): Flow<List<FeedPost>> {
        return flow {
            delay(3000)
            emit(mock.toList())
        }.flowOn(Dispatchers.IO)
    }

    fun remove(feedPost: FeedPost): Flow<Boolean> {
        return flow {
            emit(mock.remove(feedPost))
        }.flowOn(Dispatchers.IO)
    }
}
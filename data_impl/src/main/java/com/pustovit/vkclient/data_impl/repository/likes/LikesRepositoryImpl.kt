package com.pustovit.vkclient.data_impl.repository.likes

import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.data_source_api.remote.LikesRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:25
 */
internal class LikesRepositoryImpl @Inject constructor(
    private val remoteDataSource: LikesRemoteDataSource,
) : LikesRepository {

    override fun addLike(type: String, ownerId: Int, itemId: Int): Flow<Int> {
        return flow {
            emit(
                remoteDataSource.addLike(
                    type = type,
                    ownerId = ownerId,
                    itemId = itemId
                )
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteLike(type: String, ownerId: Int, itemId: Int): Flow<Int> {
        return flow {
            emit(
                remoteDataSource.deleteLike(
                    type = type,
                    ownerId = ownerId,
                    itemId = itemId
                )
            )
        }.flowOn(Dispatchers.IO)
    }
}
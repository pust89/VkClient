package com.pustovit.vkclient.data_source_impl.remote.likes

import com.pustovit.vkclient.data_source_api.remote.LikesRemoteDataSource
import com.pustovit.vkclient.data_source_impl.remote.base.process
import com.pustovit.vkclient.data_source_impl.remote.likes.api.LikesApi
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 13:58
 */
internal class LikesRemoteDataSourceImpl @Inject constructor(
    private val api: LikesApi,
) : LikesRemoteDataSource {

    override suspend fun addLike(type: String, ownerId: Int, itemId: Int): Int {
        return api.addLike(
            type = type,
            ownerId = ownerId,
            itemId = itemId
        ).process { it?.likes ?: 0 }
    }

    override suspend fun deleteLike(type: String, ownerId: Int, itemId: Int): Int {
        return api.deleteLike(
            type = type,
            ownerId = ownerId,
            itemId = itemId
        ).process { it?.likes ?: 0 }
    }

}
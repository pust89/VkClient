package com.pustovit.vkclient.data_source_api.remote

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 13:47
 */
interface LikesRemoteDataSource {

    suspend fun addLike(type: String, ownerId: Int, itemId: Int): Int

    suspend fun deleteLike(type: String, ownerId: Int, itemId: Int): Int
}
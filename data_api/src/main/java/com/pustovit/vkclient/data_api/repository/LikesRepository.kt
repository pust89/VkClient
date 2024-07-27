package com.pustovit.vkclient.data_api.repository

import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:19
 */
interface LikesRepository {

    fun addLike(type: String, ownerId: Int, itemId: Int): Flow<Int>

    fun deleteLike(type: String, ownerId: Int, itemId: Int): Flow<Int>
}
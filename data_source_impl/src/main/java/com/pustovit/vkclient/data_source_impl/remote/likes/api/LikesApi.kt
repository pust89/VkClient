package com.pustovit.vkclient.data_source_impl.remote.likes.api

import com.pustovit.vkclient.data_source_impl.remote.base.VkResponse
import com.pustovit.vkclient.data_source_impl.remote.likes.model.LikesContentDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:08
 */
internal interface LikesApi {

    @GET("likes.add")
    suspend fun addLike(
        @Query("type") type: String,
        @Query("owner_id") ownerId: Int,
        @Query("item_id") itemId: Int
    ): VkResponse<LikesContentDto>

    @GET("likes.delete")
    suspend fun deleteLike(
        @Query("type") type: String,
        @Query("owner_id") ownerId: Int,
        @Query("item_id") itemId: Int
    ): VkResponse<LikesContentDto>
}
package com.pustovit.vkclient.domain_api.likes

import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:44
 */
interface DeleteLikeUseCase {

    operator fun  invoke(type: String, ownerId: Int, itemId: Int): Flow<Int>
}
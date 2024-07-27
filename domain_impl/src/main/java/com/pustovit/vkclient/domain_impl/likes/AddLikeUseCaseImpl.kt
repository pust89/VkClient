package com.pustovit.vkclient.domain_impl.likes

import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:47
 */
class AddLikeUseCaseImpl @Inject constructor(
    private val likesRepository: LikesRepository,
) : AddLikeUseCase {

    override fun invoke(type: String, ownerId: Int, itemId: Int): Flow<Int> {
        return likesRepository.addLike(
            type = type,
            ownerId = ownerId,
            itemId = itemId
        )
    }
}
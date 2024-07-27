package com.pustovit.vkclient.domain_impl.likes

import com.pustovit.vkclient.data_api.repository.LikesRepository
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 14:47
 */
internal class DeleteLikeUseCaseImpl @Inject constructor(
    private val likesRepository: LikesRepository,
) : DeleteLikeUseCase {

    override fun invoke(type: String, ownerId: Int, itemId: Int): Flow<Int> {
        return likesRepository.deleteLike(
            type = type,
            ownerId = ownerId,
            itemId = itemId
        )
    }
}
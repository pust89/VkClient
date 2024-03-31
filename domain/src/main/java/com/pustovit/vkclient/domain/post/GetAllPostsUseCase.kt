package com.pustovit.vkclient.domain.post

import com.pustovit.vkclient.data.FeedPostRepository
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 9:46
 */
internal class GetAllPostsUseCaseImpl(
    private val feedPostRepository: FeedPostRepository
) : GetAllPostsUseCase {
    override fun invoke(): Flow<List<FeedPost>> {
        return feedPostRepository.getAll()
    }
}

interface GetAllPostsUseCase {
    operator fun invoke(): Flow<List<FeedPost>>
}
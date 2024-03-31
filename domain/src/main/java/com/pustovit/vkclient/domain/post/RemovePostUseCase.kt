package com.pustovit.vkclient.domain.post

import com.pustovit.vkclient.data.FeedPostRepository
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 9:49
 */
internal class RemovePostUseCaseImpl(
    private val feedPostRepository: FeedPostRepository
) : RemovePostUseCase {
    override fun invoke(feedPost: FeedPost): Flow<Boolean> {
        return feedPostRepository.remove(feedPost)
    }
}

interface RemovePostUseCase {

    operator fun invoke(feedPost: FeedPost): Flow<Boolean>
}
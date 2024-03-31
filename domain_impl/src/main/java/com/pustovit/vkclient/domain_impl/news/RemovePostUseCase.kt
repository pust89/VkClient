package com.pustovit.vkclient.domain_impl.news

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 9:49
 */
internal class RemovePostUseCaseImpl @Inject constructor(
    private val feedPostRepository: FeedPostRepository
) : RemovePostUseCase {
    override fun invoke(feedPost: FeedPost): Flow<Boolean> {
        return feedPostRepository.remove(feedPost)
    }
}
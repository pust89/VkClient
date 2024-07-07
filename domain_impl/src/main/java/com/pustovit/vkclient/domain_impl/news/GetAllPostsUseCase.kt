package com.pustovit.vkclient.domain_impl.news

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.domain_api.news.GetFeedPostsUseCase
import com.pustovit.vkclient.models.post.FeedPost
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 31.03.2024
 * Time: 9:46
 */
internal class GetFeedPostsUseCaseImpl @Inject constructor(
    private val feedPostRepository: FeedPostRepository
) : GetFeedPostsUseCase {
    override fun invoke(): Flow<List<FeedPost>> {
        return feedPostRepository.getFeedPosts()
    }
}

package com.pustovit.vkclient.domain_impl.news

import com.pustovit.vkclient.data_api.repository.FeedPostRepository
import com.pustovit.vkclient.domain_api.news.FeedPostPageSource
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.Page
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.combineLatest
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatten
import kotlinx.coroutines.flow.flattenConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Pustovit V.V.
 * Date: 27.07.2024
 * Time: 16:34
 */
internal class FeedPostPageSourceImpl @Inject constructor(
    private val feedPostRepository: FeedPostRepository
) : FeedPostPageSource {

    private val loadNextCommand = MutableSharedFlow<Unit>()

    private var nextPageKey: String? = null
    private var hasInitialLoading = false

    override fun getFeedPosts(): Flow<List<FeedPost>> {
        return loadNextCommand.flatMapConcat {
            feedPostRepository.getFeedPosts(startFrom = nextPageKey)
        }.map {
            hasInitialLoading = true
            nextPageKey = it.nextFrom
            it.items
        }
    }

    override suspend fun loadFirst() {
        nextPageKey = null
        hasInitialLoading = false
        loadNextCommand.emit(Unit)
    }

    override suspend fun loadNext() {
        if (nextPageKey == null && hasInitialLoading) return
        loadNextCommand.emit(Unit)
    }
}
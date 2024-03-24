package com.pustovit.vkclient.ui.screens.feed_posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain.model.FeedPost
import com.pustovit.vkclient.domain.model.StatisticItem
import com.pustovit.vkclient.domain.repository.FeedPostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.subscribe

class NewsFeedViewModel : ViewModel() {
    private val feedPostRepository = FeedPostRepository()


    private val initialState = NewsFeedScreenState.Loading

    private val _screenState = MutableStateFlow<NewsFeedScreenState>(initialState)
    val screenState: StateFlow<NewsFeedScreenState> = _screenState

    init {
        feedPostRepository.getAll()
            .onEach {
                Log.d("removeTag", "init: listSize =  ${it.size}")
                _screenState.emit(NewsFeedScreenState.Posts(it))
            }
            .launchIn(viewModelScope)
    }

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
        val currentState = screenState.value
        if (currentState !is NewsFeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(statistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
        feedPostRepository.remove(feedPost)
            .flatMapMerge {
                feedPostRepository.getAll()
            }
            .onEach {
                _screenState.emit(NewsFeedScreenState.Posts(it))
            }
            .launchIn(viewModelScope)
    }
}






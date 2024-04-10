package com.pustovit.vkclient.news_impl.presentation.feed_posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.news.GetAllPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.StatisticItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

internal class NewsFeedViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val removePostUseCase: RemovePostUseCase
) : ViewModel() {

    private val initialState = NewsFeedScreenState.Loading

    private val _screenState = MutableStateFlow<NewsFeedScreenState>(initialState)
    val screenState: StateFlow<NewsFeedScreenState> = _screenState

    init {
        getAllPostsUseCase()
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
        removePostUseCase(feedPost)
            .flatMapMerge {
                getAllPostsUseCase()
            }
            .onEach {
                _screenState.emit(NewsFeedScreenState.Posts(it))
            }
            .launchIn(viewModelScope)
    }

    fun onCommentClick(feedPost: FeedPost) {

    }

    class Factory(
        private val getAllPostsUseCase: GetAllPostsUseCase,
        private val removePostUseCase: RemovePostUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NewsFeedViewModel(
                getAllPostsUseCase = getAllPostsUseCase,
                removePostUseCase = removePostUseCase,
            ) as T
        }
    }
}






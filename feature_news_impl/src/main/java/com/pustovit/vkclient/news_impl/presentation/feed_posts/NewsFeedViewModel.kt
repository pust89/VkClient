package com.pustovit.vkclient.news_impl.presentation.feed_posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.news.GetRecommendedFeedPostsUseCase
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.StatisticItem
import com.pustovit.vkclient.screens.CommentsScreen
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.ui_common.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class NewsFeedViewModel @Inject constructor(
    private val screenNavigator: ScreenNavigator,
    private val getRecommendedFeedPostsUseCase: GetRecommendedFeedPostsUseCase,
    private val removePostUseCase: RemovePostUseCase,
) : ViewModel() {


    private val _screenState = MutableStateFlow<ScreenState<List<FeedPost>>>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState<List<FeedPost>>> = _screenState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    init {
        load()
    }

    fun load() {
        getRecommendedFeedPostsUseCase()
            .catch {
                _screenState.emit(ScreenState.Error(it.message.orEmpty()))
            }
            .onEach { list ->
                _screenState.emit(ScreenState.Data(list))
            }
            .launchIn(viewModelScope)
    }

    fun updateCount(feedPost: FeedPost, item: StatisticItem) {
//        val currentState = screenState.value
//        if (currentState !is NewsFeedScreenState.Posts) return
//
//        val oldPosts = currentState.posts.toMutableList()
//        val oldStatistics = feedPost.statistics
//        val newStatistics = oldStatistics.toMutableList().apply {
//            replaceAll { oldItem ->
//                if (oldItem.type == item.type) {
//                    oldItem.copy(count = oldItem.count + 1)
//                } else {
//                    oldItem
//                }
//            }
//        }
//        val newFeedPost = feedPost.copy(statistics = newStatistics)
//        val newPosts = oldPosts.apply {
//            replaceAll {
//                if (it.id == newFeedPost.id) {
//                    newFeedPost
//                } else {
//                    it
//                }
//            }
//        }
//        _screenState.value = NewsFeedScreenState.Posts(posts = newPosts)
    }

    fun remove(feedPost: FeedPost) {
//        removePostUseCase(feedPost)
//            .flatMapMerge {
//                getAllPostsUseCase()
//            }
//            .onEach {
//                _screenState.emit(NewsFeedScreenState.Posts(it))
//            }
//            .launchIn(viewModelScope)
    }

    fun onCommentClick(feedPost: FeedPost) {
        viewModelScope.launch {

            val args = CommentsScreen.Args(
                feedPostId = feedPost.id,
                feedPostComment = feedPost.communityName
            )

            val route = CommentsScreen.getRouteWithArgs(args)

            screenNavigator.navigateTo(
                route = route,
            )
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            getRecommendedFeedPostsUseCase()
                .catch {
                    _screenState.emit(ScreenState.Error(it.message.orEmpty()))
                }
                .onEach { user ->
                    _screenState.emit(ScreenState.Data(user))

                }
                .onCompletion {
                    _isRefreshing.emit(false)
                }
                .launchIn(viewModelScope)
        }
    }

    class Factory(
        private val screenNavigator: ScreenNavigator,
        private val getRecommendedFeedPostsUseCase: GetRecommendedFeedPostsUseCase,
        private val removePostUseCase: RemovePostUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NewsFeedViewModel(
                screenNavigator = screenNavigator,
                getRecommendedFeedPostsUseCase = getRecommendedFeedPostsUseCase,
                removePostUseCase = removePostUseCase,
            ) as T
        }
    }
}






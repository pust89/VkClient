package com.pustovit.vkclient.news_impl.presentation.feed_posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.likes.AddLikeUseCase
import com.pustovit.vkclient.domain_api.likes.DeleteLikeUseCase
import com.pustovit.vkclient.domain_api.news.FeedPostPageSource
import com.pustovit.vkclient.domain_api.news.RemovePostUseCase
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.screens.CommentsScreen
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.ui_common.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class NewsFeedViewModel @Inject constructor(
    private val screenNavigator: ScreenNavigator,
    private val feedPostPageSource: FeedPostPageSource,
    private val removePostUseCase: RemovePostUseCase,
    private val addLikeUseCase: AddLikeUseCase,
    private val deleteLikeUseCase: DeleteLikeUseCase,
) : ViewModel() {


    private val _screenState = MutableStateFlow<ScreenState<List<FeedPost>>>(ScreenState.Loading)
    val screenState: StateFlow<ScreenState<List<FeedPost>>> = _screenState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing = _isRefreshing.asStateFlow()

    init {
        feedPostPageSource.getFeedPosts()
            .catch {
                _screenState.emit(ScreenState.Error(it.message.orEmpty()))
                _isRefreshing.emit(false)
            }
            .onEach { feedPosts ->

                val newState = when (val currentState = _screenState.value) {

                    is ScreenState.Data -> currentState.copy(
                        data = currentState.data + feedPosts
                    )

                    is ScreenState.Error,
                    ScreenState.Loading -> ScreenState.Data(feedPosts)

                }
                _screenState.emit(newState)
                _isRefreshing.emit(false)
            }
            .launchIn(viewModelScope)
        loadFirst()
    }

    fun loadNext() {
        viewModelScope.launch {
            feedPostPageSource.loadNext()
        }
    }

    fun loadFirst() {
        viewModelScope.launch {
            feedPostPageSource.loadFirst()
        }
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

            screenNavigator.navigateTo(route = route)
        }
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            val newState = ScreenState.Data(emptyList<FeedPost>())
            _screenState.emit(newState)
            loadFirst()
        }
    }

    fun onLikeClick(feedPost: FeedPost) {
        viewModelScope.launch {
            if (feedPost.likes.isLiked) {
                deleteLikeUseCase(
                    type = feedPost.type,
                    ownerId = feedPost.ownerId,
                    itemId = feedPost.id
                )
            } else {
                addLikeUseCase(
                    type = feedPost.type,
                    ownerId = feedPost.ownerId,
                    itemId = feedPost.id
                )
            }.catch {
                _screenState.emit(ScreenState.Error(it.message.orEmpty()))
            }.onEach { newCount ->
                val newList = calculateUpdatedListByLikes(newCount, feedPost)
                _screenState.emit(ScreenState.Data(newList))
            }
                .launchIn(viewModelScope)
        }
    }

    private fun calculateUpdatedListByLikes(newCount: Int, feedPost: FeedPost): List<FeedPost> {
        return (_screenState.value as? ScreenState.Data<List<FeedPost>>)?.let { screenState ->
            screenState.data.map {
                if (it.id != feedPost.id) {
                    it
                } else {
                    it.copy(
                        likes = FeedPost.Likes(
                            count = newCount,
                            isLiked = !feedPost.likes.isLiked
                        )
                    )
                }
            }
        } ?: emptyList()
    }

    class Factory(
        private val screenNavigator: ScreenNavigator,
        private val feedPostPageSource: FeedPostPageSource,
        private val removePostUseCase: RemovePostUseCase,
        private val addLikeUseCase: AddLikeUseCase,
        private val deleteLikeUseCase: DeleteLikeUseCase,
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return NewsFeedViewModel(
                screenNavigator = screenNavigator,
                feedPostPageSource = feedPostPageSource,
                removePostUseCase = removePostUseCase,
                addLikeUseCase = addLikeUseCase,
                deleteLikeUseCase = deleteLikeUseCase,
            ) as T
        }
    }
}






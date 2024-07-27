package com.pustovit.vkclient.news_impl.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.PostComment
import com.pustovit.vkclient.screens.CommentsScreen
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentsViewModel(
    private val args: CommentsScreen.Args,
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    private val _screenState = MutableStateFlow<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: StateFlow<CommentsScreenState> = _screenState

    init {
        loadComments(args.feedPostId)
    }

    private fun loadComments(feedPostId: Int) {
        val comments = mutableListOf<PostComment>().apply {
            repeat(10) {
                add(PostComment(id = it))
            }
        }
        _screenState.value = CommentsScreenState.Comments(
            feedPost = FeedPost(id = feedPostId),
            comments = comments
        )
    }

    fun onBackPressed() {
        viewModelScope.launch {
            screenNavigator.back()
        }
    }

    class Factory(
        private val args: CommentsScreen.Args,
        private val screenNavigator: ScreenNavigator,
        ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CommentsViewModel(
                args = args,
                screenNavigator = screenNavigator
            ) as T
        }
    }
}

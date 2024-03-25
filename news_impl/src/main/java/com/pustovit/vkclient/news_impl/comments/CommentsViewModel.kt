package com.pustovit.vkclient.news_impl.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pustovit.vkclient.domain.model.FeedPost
import com.pustovit.vkclient.domain.model.PostComment
import com.pustovit.vkclient.news_api.screens.CommentsScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CommentsViewModel(private val args: CommentsScreen.Args) : ViewModel() {

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

    class Factory(private val args: CommentsScreen.Args) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CommentsViewModel(args) as T
        }
    }
}

package com.pustovit.vkclient.news_impl.presentation.comments

import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.models.post.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}

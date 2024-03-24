package com.pustovit.vkclient.ui.screens.feed_posts.comments

import com.pustovit.vkclient.domain.model.FeedPost
import com.pustovit.vkclient.domain.model.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}

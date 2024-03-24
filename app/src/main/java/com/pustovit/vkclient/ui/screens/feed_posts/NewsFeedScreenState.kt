package com.pustovit.vkclient.ui.screens.feed_posts

import com.pustovit.vkclient.domain.model.FeedPost

sealed class NewsFeedScreenState {

    object Loading : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}

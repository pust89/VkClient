package com.pustovit.vkclient.news_impl.presentation.feed_posts

import com.pustovit.vkclient.models.post.FeedPost

sealed class NewsFeedScreenState {

    object Loading : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}

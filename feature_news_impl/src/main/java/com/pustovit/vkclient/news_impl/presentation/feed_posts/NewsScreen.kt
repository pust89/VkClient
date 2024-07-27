@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.pustovit.vkclient.news_impl.presentation.feed_posts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pustovit.vkclient.models.post.FeedPost
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponent
import com.pustovit.vkclient.news_impl.di.NewsFeatureComponentHolder
import com.pustovit.vkclient.ui_common.compose.ErrorScreen
import com.pustovit.vkclient.ui_common.compose.LoadingItem
import com.pustovit.vkclient.ui_common.compose.LoadingScreen
import com.pustovit.vkclient.ui_common.state.ScreenState

@Composable
fun NewsScreen() {

    val component: NewsFeatureComponent = remember {
        NewsFeatureComponentHolder.component
    }

    val viewModel: NewsFeedViewModel = viewModel(factory = component.newsFeedViewModelFactory)
    val screenState by viewModel.screenState.collectAsState()
    val isRefreshingState = viewModel.isRefreshing.collectAsState()

    when (val state = screenState) {
        ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen(errorMsg = state.errorMsg){
            viewModel.load()
        }
        is ScreenState.Data -> PullToRefreshBox(
            modifier = Modifier
                .fillMaxSize(),
            content = {
                FeedPosts(
                    viewModel = viewModel,
                    posts = state.data,
                    onCommentClickListener = viewModel::onCommentClick
                )
            },
            onRefresh = { viewModel.refresh() },
            isRefreshing = isRefreshingState.value
        )

    }

}

@Composable
private fun FeedPosts(
    viewModel: NewsFeedViewModel,
    posts: List<FeedPost>,
    onCommentClickListener: (FeedPost) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 72.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = posts,
            key = { it.id }
        ) { feedPost ->


            val swipeToDismissBoxState = rememberSwipeToDismissBoxState()
            when (swipeToDismissBoxState.currentValue) {
                SwipeToDismissBoxValue.EndToStart -> {
                    viewModel.remove(feedPost)
                }

                else -> Unit
            }


            SwipeToDismissBox(
                modifier = Modifier.animateItemPlacement(),
                state = swipeToDismissBoxState,
                enableDismissFromStartToEnd = false,
                backgroundContent = { LoadingItem() }) {
                PostCard(
                    feedPost = feedPost,
                    onViewsClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onShareClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                    onCommentClickListener = {
                        onCommentClickListener(feedPost)
                    },
                    onLikeClickListener = { statisticItem ->
                        viewModel.updateCount(feedPost, statisticItem)
                    },
                )
            }
        }
    }
}






package com.pustovit.vkclient.navigation.graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.domain.model.FeedPost
import com.pustovit.vkclient.navigation.screens.CommentsScreen
import com.pustovit.vkclient.navigation.screens.NewsFeedScreen

/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 19:47
 */

fun NavGraphBuilder.homeNavigation(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = NewsFeedScreen.route,
        route = NavigationGraph.Home.route
    ) {
        composable(NewsFeedScreen.route) {
            newsFeedScreenContent()
        }
        composable(
            route = CommentsScreen.route,
            arguments = CommentsScreen.arguments,
        ) { navBackStackEntry ->
            val feedPostId =
                navBackStackEntry.arguments?.getInt(CommentsScreen.ARG_FEED_POST_ID) ?: 99

            val feedPosContentText =
                navBackStackEntry.arguments?.getString(CommentsScreen.ARG_FEED_POST_CONTENT_TEXT)
            Log.d("navTag", "homeNavigation: feedPosContentText=$feedPosContentText")
            commentsScreenContent(FeedPost(id = feedPostId))
        }
    }
}
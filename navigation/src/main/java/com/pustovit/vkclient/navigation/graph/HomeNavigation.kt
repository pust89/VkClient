package com.pustovit.vkclient.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.news_api.screens.CommentsScreen
import com.pustovit.vkclient.news_api.screens.NewsFeedScreen
import com.pustovit.vkclient.ui_common.screen.getDecodedString

/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 19:47
 */
fun NavGraphBuilder.homeNavigation(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (CommentsScreen.Args) -> Unit,
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

            val args = CommentsScreen.Args(
                feedPostId = navBackStackEntry.arguments?.getInt(CommentsScreen.ARG_FEED_POST_ID)
                    ?: 99,
                feedPostComment = navBackStackEntry.arguments?.getDecodedString(CommentsScreen.ARG_FEED_POST_CONTENT_TEXT)
                    .orEmpty()
            )

            commentsScreenContent(args)
        }
    }
}
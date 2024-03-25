package com.pustovit.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.domain.model.FeedPost
import com.pustovit.vkclient.news_api.screens.CommentsScreen
import com.pustovit.vkclient.navigation.tabs.NavigationTab

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigateToTab(tab: NavigationTab) {
        navHostController.navigate(tab.graph.route) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateToCommentsScreen(feedPost: FeedPost) {
        val args = CommentsScreen.Args(
            feedPostId = feedPost.id,
            feedPostComment = feedPost.contentText,
        )
        navHostController.navigate(CommentsScreen.getRouteWithArgs(args))
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}

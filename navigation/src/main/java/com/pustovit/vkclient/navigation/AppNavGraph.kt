package com.pustovit.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pustovit.vkclient.navigation.graph.NavigationGraph
import com.pustovit.vkclient.navigation.graph.favouriteNavigation
import com.pustovit.vkclient.navigation.graph.homeNavigation
import com.pustovit.vkclient.navigation.graph.profileNavigation
import com.pustovit.vkclient.news_api.screens.CommentsScreen


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (com.pustovit.vkclient.news_api.screens.CommentsScreen.Args) -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationGraph.Home.route
    ) {
        homeNavigation(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent,
        )

        favouriteNavigation { favouriteScreenContent() }

        profileNavigation { profileScreenContent() }
    }
}

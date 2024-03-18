package com.pustovit.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pustovit.vkclient.navigation.graphs.NavigationGraph
import com.pustovit.vkclient.navigation.graphs.favouriteNavigation
import com.pustovit.vkclient.navigation.graphs.homeNavigation
import com.pustovit.vkclient.navigation.graphs.profileNavigation

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable () -> Unit,
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

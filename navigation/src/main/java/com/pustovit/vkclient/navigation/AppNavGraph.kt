package com.pustovit.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pustovit.vkclient.navigation.graph.NavigationGraph
import com.pustovit.vkclient.navigation.graph.authNavigation
import com.pustovit.vkclient.navigation.graph.favouriteNavigation
import com.pustovit.vkclient.navigation.graph.newsNavigation
import com.pustovit.vkclient.navigation.graph.profileNavigation
import com.pustovit.vkclient.navigation.graph.splashNavigation
import com.pustovit.vkclient.news_api.screens.CommentsScreen


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (CommentsScreen.Args) -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
    authScreenContent: @Composable () -> Unit,
    splashScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = NavigationGraph.Auth.route
    ) {

        splashNavigation { splashScreenContent() }
        authNavigation { authScreenContent() }

        newsNavigation(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent,
        )

        favouriteNavigation { favouriteScreenContent() }

        profileNavigation { profileScreenContent() }

    }
}

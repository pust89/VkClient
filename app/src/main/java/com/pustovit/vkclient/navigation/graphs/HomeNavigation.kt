package com.pustovit.vkclient.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.navigation.screens.Screen

/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 19:47
 */

fun NavGraphBuilder.homeNavigation(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable () -> Unit,
){
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = NavigationGraph.Home.route
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedScreenContent()
        }
        composable(Screen.Comments.route) {
            commentsScreenContent()
        }
    }
}
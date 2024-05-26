package com.pustovit.vkclient.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import com.pustovit.vkclient.screens.Screen

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
    fun navigateTo(screen: Screen) {
        navHostController.navigate(screen.route)
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
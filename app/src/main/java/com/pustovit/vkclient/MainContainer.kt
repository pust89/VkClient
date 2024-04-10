package com.pustovit.vkclient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.navigation.AppNavGraph
import com.pustovit.vkclient.navigation.NavigationState
import com.pustovit.vkclient.screens.Screen

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:36
 */
@Composable
fun MainContainer(screen: State<Screen>) {
    val navigationState = rememberNavigationState()
    AppNavGraph(navHostController = navigationState.navHostController)
    navigationState.navHostController.navigate()
    navigationState.navigateTo(screen)
    navigationState.navigateTo(screen.value)
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}

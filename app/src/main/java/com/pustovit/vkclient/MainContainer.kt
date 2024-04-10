package com.pustovit.vkclient

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.navigation.AppNavGraph
import com.pustovit.vkclient.screens.Screen

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:36
 */
@Composable
fun MainContainer(screenState: State<Screen>) {
    val navHostController: NavHostController = rememberNavController()
    AppNavGraph(navHostController = navHostController)
    val screen = screenState.value
    navHostController.navigate(
        route = screen.route,

    )
}

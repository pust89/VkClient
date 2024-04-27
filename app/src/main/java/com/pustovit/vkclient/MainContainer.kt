package com.pustovit.vkclient

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.contains
import com.pustovit.vkclient.navigation.AppGraph
import com.pustovit.vkclient.screens.Screen
import com.pustovit.vkclient.screens.SplashScreen

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:36
 */
@Composable
fun MainContainer(
    screenState: State<Screen>,
) {

    val navHostController: NavHostController = rememberNavController()
    val screen = screenState.value
    val screenRoute = screen.route
    var isInitializeGraphSet: Boolean = rememberSaveable {
        false
    }
    AppGraph(
        graphPrefix = "graph_",
        start = SplashScreen,
        navHostController = navHostController
    )
    navHostController.navigate(screen.route)



    val startDestinationRoute = navHostController.graph.startDestinationRoute
    Log.d("nTag", "MainContainer: startDestinationRoute=$startDestinationRoute")
    val currentDestinationRoute = navHostController.currentDestination?.route


//    if (graphState.value.route == screen.route) {
//
//        if (!navHostController.graph.contains("graph_" + graph.route)) {
//            navHostController.graph = AppGraph(
//                graphPrefix = "graph_",
//                start = graph,
//                navHostController = navHostController
//            )
//
//        }
//    } else {
//        if (!navHostController.graph.contains("graph_" + graph.route)) {
//            navHostController.graph.addAll(
//                AppGraph(
//                    graphPrefix = "graph_",
//                    start = screen,
//                    navHostController = navHostController
//                )
//            )
//        }
//
//        if (currentDestinationRoute != screen.route) {
//            navHostController.navigate(screen.route)
//        }
//    }
}

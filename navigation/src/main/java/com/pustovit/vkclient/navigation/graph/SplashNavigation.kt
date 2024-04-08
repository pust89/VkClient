package com.pustovit.vkclient.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.auth_api.AuthScreen
import com.pustovit.vkclient.splash_api.SplashScreen

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 21:38
 */

fun NavGraphBuilder.splashNavigation(
    splashScreenContent:  @Composable () -> Unit
) {
    navigation(
        startDestination = SplashScreen.route,
        route = NavigationGraph.Splash.route
    ) {
        composable(SplashScreen.route) {
            splashScreenContent()
        }
    }
}
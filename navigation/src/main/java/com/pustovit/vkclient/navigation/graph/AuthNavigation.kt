package com.pustovit.vkclient.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.auth_api.AuthScreen

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 22:06
 */

fun NavGraphBuilder.authNavigation(
    authScreenContent:  @Composable  () -> Unit
) {
    navigation(
        startDestination = AuthScreen.route,
        route = NavigationGraph.Auth.route
    ) {
        composable(AuthScreen.route) {
            authScreenContent()
        }
    }
}
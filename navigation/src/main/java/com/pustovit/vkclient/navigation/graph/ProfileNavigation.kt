package com.pustovit.vkclient.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.navigation.screens.ProfileScreen

/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 20:13
 */

fun NavGraphBuilder.profileNavigation(
    profileScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = ProfileScreen.route,
        route = NavigationGraph.Profile.route
    ) {
        composable(ProfileScreen.route) {
            profileScreenContent()
        }
    }
}
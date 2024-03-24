package com.pustovit.vkclient.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.navigation.screens.FavouriteScreen

/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 20:11
 */
fun NavGraphBuilder.favouriteNavigation(
    favouriteScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = FavouriteScreen.route,
        route = NavigationGraph.Favorite.route
    ) {
        composable(FavouriteScreen.route) {
            favouriteScreenContent()
        }
    }
}
package com.pustovit.vkclient.navigation.graph


/**
 * Created by Pustovit V.V.
 * Date: 18.03.2024
 * Time: 19:41
 */
sealed class NavigationGraph(
    val route: String
) {
    object Home : NavigationGraph(HOME_NAVIGATION_ROUTE)
    object Favorite : NavigationGraph(FAVORITE_NAVIGATION_ROUTE)
    object Profile : NavigationGraph(PROFILE_NAVIGATION_ROUTE)

    private companion object {
        const val HOME_NAVIGATION_ROUTE = "home_navigation_route"
        const val FAVORITE_NAVIGATION_ROUTE = "favorite_navigation_route"
        const val PROFILE_NAVIGATION_ROUTE = "profile_navigation_route"
    }
}


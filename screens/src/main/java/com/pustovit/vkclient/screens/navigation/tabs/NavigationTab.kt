package com.pustovit.vkclient.screens.navigation.tabs

import com.pustovit.vkclient.screens.R
import com.pustovit.vkclient.screens.navigation.graph.NavigationGraph

sealed class NavigationTab(
    val graph: NavigationGraph,
    val titleResId: Int,
) {

    object Home : NavigationTab(
        graph = NavigationGraph.Home,
        titleResId = R.string.navigation_item_news,
    )

    object Favourite : NavigationTab(
        graph = NavigationGraph.Favorite,
        titleResId = R.string.navigation_item_favourite,
    )

    object Profile : NavigationTab(
        graph = NavigationGraph.Profile,
        titleResId = R.string.navigation_item_profile,
    )
}

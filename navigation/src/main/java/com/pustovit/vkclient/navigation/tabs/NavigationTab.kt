package com.pustovit.vkclient.navigation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.pustovit.vkclient.navigation.R
import com.pustovit.vkclient.navigation.graph.NavigationGraph

sealed class NavigationTab(
    val graph: NavigationGraph,
    val titleResId: Int,
    val icon: ImageVector,
) {
    object Home : NavigationTab(
        graph = NavigationGraph.Home,
        titleResId = R.string.navigation_item_news,
        icon = Icons.Outlined.Home,
    )

    object Favourite : NavigationTab(
        graph = NavigationGraph.Favorite,
        titleResId = R.string.navigation_item_favourite,
        icon = Icons.Outlined.Favorite,
    )

    object Profile : NavigationTab(
        graph = NavigationGraph.Profile,
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person,
    )
}

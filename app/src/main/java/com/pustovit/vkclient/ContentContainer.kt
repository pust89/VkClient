package com.pustovit.vkclient

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pustovit.vkclient.navigation.AppGraph
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab

/**
 * Created by Pustovit V.V.
 * Date: 05.05.2024
 * Time: 15:50
 */
@Composable
fun ContentContainer(
    navController: NavHostController,
    onTabClick: (tab: NavigationTab, navHostController: NavHostController) -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Log.d("navTag", "ContentContainer: ${navBackStackEntry?.destination?.parent} ")

    Scaffold(
        bottomBar = {
            VkClientBottomAppBar(
                navHostController = navController,
                onTabClick = onTabClick
            )
        }
    ) { paddingValues ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            AppGraph(navHostController = navController)
        }
    }
}


@Composable
private fun VkClientBottomAppBar(
    navHostController: NavHostController,
    onTabClick: (tab: NavigationTab, navHostController: NavHostController) -> Unit,
) {
    BottomAppBar {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()

        val tabs = listOf(
            NavigationTab.Home,
            NavigationTab.Favourite,
            NavigationTab.Profile
        )
        tabs.forEach { tab ->
            val isSelected = tab.isSelected(navBackStackEntry)

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (isSelected.not()) {
                        onTabClick(tab, navHostController)
                    }
                },
                icon = {
                    val icon = when (tab) {
                        NavigationTab.Home -> Icons.Outlined.Home
                        NavigationTab.Favourite -> Icons.Outlined.Favorite
                        NavigationTab.Profile -> Icons.Outlined.Person
                    }
                    Icon(icon, contentDescription = null)
                },
                label = {
                    Text(text = stringResource(id = tab.titleResId))
                },
            )
        }
    }
}

private fun NavigationTab.isSelected(navBackStackEntry: NavBackStackEntry?): Boolean {
    return navBackStackEntry?.destination?.hierarchy?.any {
        it.route == this.graph.route
    } ?: false
}



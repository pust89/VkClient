package com.pustovit.vkclient.ui

import android.util.Log
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pustovit.vkclient.navigation.AppGraph
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab

/**
 * Created by Pustovit V.V.
 * Date: 05.05.2024
 * Time: 15:50
 */
@Composable
fun ContentContainer(
    navHostController: NavHostController,
    onTabClick: (NavigationTab) -> Unit
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    Log.d("navTag", "ContentContainer: ${navBackStackEntry?.destination?.route} ")
    when (navBackStackEntry?.destination?.route) {
        null,
        SplashScreen.route,
        AuthScreen.route -> {
            Scaffold { paddingValues ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    AppGraph(navHostController = navHostController)
                }
            }
        }

        else -> {
            Scaffold(
                bottomBar = {
                    VkClientBottomAppBar(
                        navHostController = navHostController,
                        onTabClick = onTabClick
                    )
                }
            ) { paddingValues ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    AppGraph(navHostController = navHostController)
                }
            }
        }

    }

}


@Composable
private fun VkClientBottomAppBar(
    navHostController: NavHostController,
    onTabClick: (NavigationTab) -> Unit
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
                            //onTabClick(tab)
                            navHostController.navigate(tab.graph.route) {
                                popUpTo(navHostController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
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

@Composable
private fun TextCounter(name: String) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Text(
        modifier = Modifier.clickable { count++ },
        text = "$name Count: $count",
        color = Color.Black
    )
}

private fun NavigationTab.isSelected(navBackStackEntry: NavBackStackEntry?): Boolean {
    return navBackStackEntry?.destination?.hierarchy?.any {
        it.route == this.graph.route
    } ?: false
}



package com.pustovit.vkclient.ui

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab

/**
 * Created by Pustovit V.V.
 * Date: 05.05.2024
 * Time: 15:50
 */
//@Composable
//fun ContentContainer(navHostController:NavHostController) {
//    Scaffold(
//        bottomBar = {
//            BottomAppBar {
//
//                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
//
//                val tabs = listOf(
//                    NavigationTab.Home,
//                    NavigationTab.Favourite,
//                    NavigationTab.Profile
//                )
//
//                tabs.forEach { tab ->
//                    val isSelected = tab.isSelected(navBackStackEntry)
//
//                    NavigationBarItem(
//                        selected = isSelected,
//                        onClick = {
//                            if (isSelected.not()) {
//                                navigationState.navigateToTab(tab)
//                            }
//                        },
//                        icon = {
//                            val icon = when(tab){
//                                NavigationTab.Home -> Icons.Outlined.Home
//                                NavigationTab.Favourite -> Icons.Outlined.Favorite
//                                NavigationTab.Profile -> Icons.Outlined.Person
//                            }
//                            Icon(icon, contentDescription = null)
//                        },
//                        label = {
//                            Text(text = stringResource(id = tab.titleResId))
//                        },
//                    )
//                }
//            }
//        }
//    ) { paddingValues ->
//
//        AppNavGraph(
//            navHostController = navigationState.navHostController,
//            splashScreenContent = { SplashScreen() },
//            authScreenContent = { AuthScreen() },
//            newsFeedScreenContent = {
//                NewsScreen(
//                    paddingValues = paddingValues,
//                    onCommentClickListener = navigationState::navigateToCommentsScreen
//                )
//            },
//            commentsScreenContent = { args ->
//                CommentsScreen(args) {
//                    navigationState.navHostController.popBackStack()
//                }
//            },
//            favouriteScreenContent = {
//                TextCounter(name = "Favorite")
//
//            },
//            profileScreenContent = { TextCounter(name = "Profile") }
//        )
//    }
//}
//
//@Composable
//private fun TextCounter(name: String) {
//    var count by rememberSaveable {
//        mutableStateOf(0)
//    }
//
//    Text(
//        modifier = Modifier.clickable { count++ },
//        text = "$name Count: $count",
//        color = Color.Black
//    )
//}
//
//private fun NavigationTab.isSelected(navBackStackEntry: NavBackStackEntry?): Boolean {
//    return navBackStackEntry?.destination?.hierarchy?.any {
//        it.route == this.graph.route
//    } ?: false
//}
//
//

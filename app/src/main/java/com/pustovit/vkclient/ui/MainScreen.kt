@file:OptIn(ExperimentalMaterial3Api::class)

package com.pustovit.vkclient.ui

import androidx.compose.foundation.clickable
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pustovit.vkclient.splash_impl.presentation.SplashScreen
import com.pustovit.vkclient.auth_impl.presentation.AuthScreen
import com.pustovit.vkclient.navigation.AppNavGraph
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsScreen
import com.pustovit.vkclient.navigation.tabs.NavigationTab
import com.pustovit.vkclient.navigation.rememberNavigationState
import com.pustovit.vkclient.news_impl.presentation.comments.CommentsScreen

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            BottomAppBar {

                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

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
                                navigationState.navigateToTab(tab)
                            }
                        },
                        icon = {
                            Icon(tab.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = tab.titleResId))
                        },
                    )
                }
            }
        }
    ) { paddingValues ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            splashScreenContent = { SplashScreen() },
            authScreenContent = { AuthScreen() },
            newsFeedScreenContent = {
                NewsScreen(
                    paddingValues = paddingValues,
                    onCommentClickListener = navigationState::navigateToCommentsScreen
                )
            },
            commentsScreenContent = { args ->
                CommentsScreen(args) {
                    navigationState.navHostController.popBackStack()
                }
            },
            favouriteScreenContent = {
                TextCounter(name = "Favorite")

            },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
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



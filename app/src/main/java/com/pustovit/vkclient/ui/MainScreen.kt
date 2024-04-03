@file:OptIn(ExperimentalMaterial3Api::class)

package com.pustovit.vkclient.ui

import android.util.Log
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pustovit.vkclient.navigation.AppNavGraph
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsScreen
import com.pustovit.vkclient.navigation.tabs.NavigationTab
import com.pustovit.vkclient.navigation.rememberNavigationState
import com.pustovit.vkclient.news_impl.presentation.comments.CommentsScreen
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.onetap.common.OneTapOAuth
import com.vk.id.onetap.common.OneTapStyle
import com.vk.id.onetap.compose.onetap.OneTap

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
                OneTap(
                    modifier = Modifier,
                    oAuths = emptySet(),
                    style = OneTapStyle.Light(),
                    onAuth = ::onAuthSuccess,
                    onFail = ::onAuthFail,
                    vkid = VKID(LocalContext.current),
                    signInAnotherAccountButtonEnabled = false
                )
            },
            profileScreenContent = { TextCounter(name = "Profile") }
        )
    }
}

private fun onAuthSuccess(oneTapOAuth: OneTapOAuth?, accessToken: AccessToken) {
    Log.d("vkTag", "onAuthSuccess: accessToken=${accessToken}")
}

private fun onAuthFail(oneTapOAuth: OneTapOAuth?, vKIDAuthFail: VKIDAuthFail) {
    Log.d("vkTag", "onAuthFail: vKIDAuthFail=${vKIDAuthFail.description}")
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



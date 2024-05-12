package com.pustovit.vkclient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import kotlinx.coroutines.launch

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:38
 */
class MainViewModel(
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    val screenFlow = screenNavigator.listenNavIntent()

    class Factory(private val screenNavigator: ScreenNavigator) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                screenNavigator = screenNavigator
            ) as T
        }
    }

    fun onTabClick(tab: NavigationTab) {
        viewModelScope.launch {

            screenNavigator.navigateTo(
                route = tab.graph.route,
                navOptions = NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .setRestoreState(true)
                    .setPopUpTo(
                        route = NavigationTab.Home.graph.route,
                        inclusive = false,
                        saveState = true
                    )
                    .build()
            )
        }
    }
}
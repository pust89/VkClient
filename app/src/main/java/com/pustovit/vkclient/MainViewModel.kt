package com.pustovit.vkclient

import android.util.Log
import androidx.collection.forEach
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.get
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.screens.Screen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.NavIntent
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.screens.navigation.graph.NavigationGraph
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.concatWith
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:38
 */
class MainViewModel(
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    val screenFlow = screenNavigator
        .listenNavIntent()

    val showBottomBar = screenNavigator.listenNavIntent().map {
        if (it is NavIntent.NavigateTo) {
            when (it.route) {
                SplashScreen.route,
                AuthScreen.route -> false

                else -> true
            }
        } else {
            true
        }
    }


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
            val navOptionsBuilder = NavOptions.Builder()
            navOptionsBuilder.setPopUpTo(
                route = NavigationGraph.Content.route,
                inclusive = false,
                saveState = true
            )
            navOptionsBuilder.setRestoreState(true)
            navOptionsBuilder.setLaunchSingleTop(true)

            screenNavigator.navigateTo(
                route = tab.graph.route,
                navOptions = navOptionsBuilder.build()
            )
        }
    }
}

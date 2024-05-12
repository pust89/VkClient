package com.pustovit.vkclient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.NavIntent
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.concatWith
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf
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


    class Factory(private val screenNavigator: ScreenNavigator) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                screenNavigator = screenNavigator
            ) as T
        }
    }

    fun onTabClick(tab: NavigationTab, navHostController: NavHostController) {
        viewModelScope.launch {

            val navOptionsBuilder = NavOptions.Builder()
            navOptionsBuilder.setRestoreState(true)
            navOptionsBuilder.setLaunchSingleTop(true)
            navOptionsBuilder.setPopUpTo(
                destinationId = navHostController.graph.findStartDestination().id,
                inclusive = false,
                saveState = true
            )
            screenNavigator.navigateTo(
                route = tab.graph.route,
                navOptions = navOptionsBuilder.build()
            )
        }
    }
}

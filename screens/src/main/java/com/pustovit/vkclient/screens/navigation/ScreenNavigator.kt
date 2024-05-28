package com.pustovit.vkclient.screens.navigation

import androidx.navigation.NavOptions
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 21:44
 */
interface ScreenNavigator {

    fun listenNavIntent(): Flow<NavIntent>

    suspend fun navigateTo(route: String, navOptions: NavOptions? = defaultNavOptions)

    suspend fun back()

    suspend fun navigateUp()

    suspend fun backTo(route: String, inclusive: Boolean, saveState: Boolean)

    val defaultNavOptions: NavOptions
        get() = NavOptions.Builder().apply {
            setRestoreState(true)
            setLaunchSingleTop(true)
        }.build()

}
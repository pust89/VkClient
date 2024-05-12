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

    suspend fun navigateTo(route: String, navOptions: NavOptions? = null)

    suspend fun back()

    suspend fun backTo(route: String, inclusive: Boolean, saveState: Boolean)
}
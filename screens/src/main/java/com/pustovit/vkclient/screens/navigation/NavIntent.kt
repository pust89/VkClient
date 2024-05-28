package com.pustovit.vkclient.screens.navigation

import androidx.navigation.NavOptions
import com.pustovit.vkclient.screens.navigation.graph.NavigationGraph

/**
 * Created by Pustovit V.V.
 * Date: 05.05.2024
 * Time: 14:09
 */
sealed interface NavIntent {
    data class NavigateTo(
        val route: String,
        val navOptions: NavOptions? = null,
    ) : NavIntent

    object Back : NavIntent

    object NavigateUp : NavIntent

    data class BackTo(val route: String, val inclusive: Boolean, val saveState: Boolean) : NavIntent
}


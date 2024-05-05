package com.pustovit.vkclient.navigation

import androidx.navigation.NavOptions
import com.pustovit.vkclient.screens.navigation.NavIntent
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:44
 */
internal class ScreenNavigatorImpl : ScreenNavigator {

    private val screenSharedFlow = MutableSharedFlow<NavIntent>()

    override fun listenNavIntent(): Flow<NavIntent> {
        return screenSharedFlow
    }

    override suspend fun navigateTo(route: String, navOptions: NavOptions?) {
        screenSharedFlow.emit(
            NavIntent.NavigateTo(
                route = route,
                navOptions = navOptions
            )
        )
    }

    override suspend fun back() {
        screenSharedFlow.emit(NavIntent.Back)
    }

    override suspend fun backTo(route: String, inclusive: Boolean, saveState: Boolean) {
        screenSharedFlow.emit(
            NavIntent.BackTo(
                route = route,
                inclusive = inclusive,
                saveState = saveState
            )
        )

    }
}
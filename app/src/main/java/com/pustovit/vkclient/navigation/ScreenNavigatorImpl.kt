package com.pustovit.vkclient.navigation

import com.pustovit.vkclient.screens.Screen
import com.pustovit.vkclient.screens.core.ScreenNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:44
 */
internal class ScreenNavigatorImpl : ScreenNavigator {

    private val screenSharedFlow = MutableSharedFlow<Screen>()
    private val graphsSharedFlow = MutableSharedFlow<Screen>()

    override suspend fun <T : Screen> emit(screen: T, startNewGraph: Boolean) {
        if (startNewGraph) {
            graphsSharedFlow.emit(screen)
        } else {
            screenSharedFlow.emit(screen)
        }
    }

    override fun listenScreens(): Flow<Screen> {
        return screenSharedFlow
    }

    override fun listenGraphs(): Flow<Screen> {
        return graphsSharedFlow
    }
}
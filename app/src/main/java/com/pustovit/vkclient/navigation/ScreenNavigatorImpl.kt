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

    private val screenSharedFlow = MutableSharedFlow<Screen>(extraBufferCapacity = Int.MAX_VALUE)
    override suspend fun <T : Screen> emit(screen: T) {
        screenSharedFlow.emit(screen)
    }

    override fun listen(): Flow<Screen> {
        return screenSharedFlow
    }
}
package com.pustovit.vkclient.screens.core

import com.pustovit.vkclient.screens.Screen
import kotlinx.coroutines.flow.Flow

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 21:44
 */
interface ScreenNavigator {
    suspend fun <T : Screen> emit(screen: T, startNewGraph: Boolean = false)

    fun listenScreens(): Flow<Screen>
    fun listenGraphs(): Flow<Screen>

}
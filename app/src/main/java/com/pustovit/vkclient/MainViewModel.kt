package com.pustovit.vkclient

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pustovit.vkclient.screens.core.ScreenNavigator

/**
 * Created by Pustovit V.V.
 * Date: 10.04.2024
 * Time: 22:38
 */
class MainViewModel(
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    val screenFlow = screenNavigator.listenScreens()
    val graphFlow = screenNavigator.listenGraphs()

    class Factory(private val screenNavigator: ScreenNavigator) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(
                screenNavigator = screenNavigator
            ) as T
        }
    }
}
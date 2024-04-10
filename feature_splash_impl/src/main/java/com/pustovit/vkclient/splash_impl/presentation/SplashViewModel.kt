package com.pustovit.vkclient.splash_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.models.auth.VkAccessToken
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.core.ScreenNavigator
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.ui_common.ext.TAG
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 21:30
 */
class SplashViewModel(
    private val getVkAccessTokenUseCase: GetVkAccessTokenUseCase,
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    init {
        getVkAccessTokenUseCase.invoke()
            .onEach(::onVkAccessToke)
            .catch {
                Log.e(TAG, "init: ", it)
            }
            .launchIn(viewModelScope)
    }

    private fun onVkAccessToke(vkAccessToken: VkAccessToken?) {
        viewModelScope.launch {
            if (vkAccessToken != null) {
                screenNavigator.emit(NewsScreen)
            } else {
                screenNavigator.emit(AuthScreen)
            }
        }
    }

    class Factory(
        private val getVkAccessTokenUseCase: GetVkAccessTokenUseCase,
        private val screenNavigator: ScreenNavigator,
    ) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SplashViewModel(
                getVkAccessTokenUseCase = getVkAccessTokenUseCase,
                screenNavigator = screenNavigator
            ) as T
        }
    }
}
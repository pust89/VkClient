package com.pustovit.vkclient.splash_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.auth.GetVkAccessTokenUseCase
import com.pustovit.vkclient.ui_common.screen.TAG
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 21:30
 */
class SplashViewModel(
    private val getVkAccessTokenUseCase: GetVkAccessTokenUseCase,
) : ViewModel() {

    init {
        getVkAccessTokenUseCase.invoke()
            .onEach {
                Log.d(TAG, "vkAccessToken = $it ")
            }
            .launchIn(viewModelScope)
    }

    class Factory(private val getVkAccessTokenUseCase: GetVkAccessTokenUseCase) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SplashViewModel(getVkAccessTokenUseCase) as T
        }
    }
}
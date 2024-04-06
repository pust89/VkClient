package com.pustovit.vkclient.auth_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail
import com.vk.id.onetap.common.OneTapOAuth

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:06
 */
class AuthViewModel(private val saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase) : ViewModel() {

    fun onAuthSuccess(oneTapOAuth: OneTapOAuth?, accessToken: AccessToken) {
        Log.d("vkTag", "onAuthSuccess: accessToken=${accessToken}")
    }

    fun onAuthFail(oneTapOAuth: OneTapOAuth?, vKIDAuthFail: VKIDAuthFail) {
        Log.d("vkTag", "onAuthFail: vKIDAuthFail=${vKIDAuthFail.description}")
    }

    class Factory(private val saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel(saveVkAccessTokenUseCase) as T
        }
    }
}
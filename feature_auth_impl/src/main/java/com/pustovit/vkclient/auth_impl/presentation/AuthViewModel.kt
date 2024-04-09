package com.pustovit.vkclient.auth_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.models.auth.VKIDUser
import com.pustovit.vkclient.models.auth.VkAccessToken
import com.pustovit.vkclient.ui_common.screen.TAG
import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail
import com.vk.id.onetap.common.OneTapOAuth
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:06
 */
class AuthViewModel(private val saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase) : ViewModel() {

    fun onAuthSuccess(oneTapOAuth: OneTapOAuth?, accessToken: AccessToken) {
        Log.d(TAG, "onAuthSuccess: accessToken=${accessToken}")
        saveVkAccessTokenUseCase.invoke(
            token = VkAccessToken(
                token = accessToken.token,
                userID = accessToken.userID,
                expireTime = accessToken.expireTime,
                userData = VKIDUser(
                    firstName = accessToken.userData.firstName,
                    lastName = accessToken.userData.lastName,
                    phone = accessToken.userData.phone,
                    photo50 = accessToken.userData.photo50,
                    photo100 = accessToken.userData.photo100,
                    photo200 = accessToken.userData.photo200,
                    email = accessToken.userData.email,
                ),
            )
        )
            .catch {
                Log.e(TAG, "onAuthSuccess: ", it)
            }
            .onEach {
                //TODO  навигируемся к новостям
            }
            .launchIn(viewModelScope)
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
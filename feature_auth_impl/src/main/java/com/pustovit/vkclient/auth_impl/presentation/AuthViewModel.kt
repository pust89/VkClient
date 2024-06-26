package com.pustovit.vkclient.auth_impl.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.pustovit.vkclient.domain_api.auth.SaveVkAccessTokenUseCase
import com.pustovit.vkclient.models.auth.VKIDUser
import com.pustovit.vkclient.models.auth.VkAccessToken
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.screens.navigation.graph.NavigationGraph
import com.pustovit.vkclient.ui_common.ext.loggError
import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail
import com.vk.id.onetap.common.OneTapOAuth
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:06
 */
class AuthViewModel(
    private val saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase,
    private val screenNavigator: ScreenNavigator,
) : ViewModel() {

    fun onAuthSuccess(oneTapOAuth: OneTapOAuth?, accessToken: AccessToken) {
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
                it.loggError()
            }
            .onEach {
                screenNavigator.navigateTo(
                    route = NavigationGraph.Content.route,
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(
                            route =  com.pustovit.vkclient.screens.AuthScreen.route,
                            inclusive = true,
                        )
                        .build()
                )
            }
            .launchIn(viewModelScope)
    }

    fun onAuthFail(oneTapOAuth: OneTapOAuth?, vKIDAuthFail: VKIDAuthFail) {
        Log.e("TAG", "onAuthFail: vKIDAuthFail=${vKIDAuthFail.description}")
    }

    class Factory(
        private val saveVkAccessTokenUseCase: SaveVkAccessTokenUseCase,
        private val screenNavigator: ScreenNavigator,
    ) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel(
                saveVkAccessTokenUseCase = saveVkAccessTokenUseCase,
                screenNavigator = screenNavigator
            ) as T
        }
    }
}
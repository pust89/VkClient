package com.pustovit.vkclient.profile_impl.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.models.user.UserSettings
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.ui_common.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

/**
 * Created by Pustovit V.V.
 * Date: 27.05.2024
 * Time: 14:33
 */
class UserSettingsViewModel(
    private val screenNavigator: ScreenNavigator,
    private val logoutUseCase: LogoutUseCase,
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState<UserSettings>>(ScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    init {
        viewModelScope.launch {
            _screenState.emit(
                ScreenState.Data(UserSettings(isDarkTheme = false))
            )
        }
    }

    fun onBackPressed() {
        viewModelScope.launch {
            screenNavigator.back()
        }
    }

    fun onLogoutClick() {
        viewModelScope.launch {
            logoutUseCase()
                .catch {
                    _screenState.emit(ScreenState.Error(it.message.orEmpty()))
                }
                .onEach {
                   val navOptions =  NavOptions.Builder().apply {
                        setRestoreState(false)
                        setLaunchSingleTop(true)
                            .setPopUpTo("app_graph",true)
                    }.build()
                    screenNavigator.navigateTo(
                        AuthScreen.route,
                        navOptions = navOptions
                        )
                }
                .launchIn(viewModelScope)
        }
    }

    class Factory(
        private val screenNavigator: ScreenNavigator,
        private val logoutUseCase: LogoutUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserSettingsViewModel(
                screenNavigator = screenNavigator,
                logoutUseCase = logoutUseCase,
            ) as T
        }
    }
}
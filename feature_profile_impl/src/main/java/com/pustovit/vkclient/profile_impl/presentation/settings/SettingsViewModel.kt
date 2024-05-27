package com.pustovit.vkclient.profile_impl.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.auth.LogoutUseCase
import com.pustovit.vkclient.models.user.UserSettings
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.ui_common.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by Pustovit V.V.
 * Date: 27.05.2024
 * Time: 14:33
 */
class SettingsViewModel(
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

    fun onLogoutClick() {

    }

    class Factory(
        private val screenNavigator: ScreenNavigator,
        private val logoutUseCase: LogoutUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SettingsViewModel(
                screenNavigator = screenNavigator,
                logoutUseCase = logoutUseCase,
            ) as T
        }
    }
}
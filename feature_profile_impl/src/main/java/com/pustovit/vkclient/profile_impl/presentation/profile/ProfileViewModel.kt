package com.pustovit.vkclient.profile_impl.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.pustovit.vkclient.domain_api.user.GetCurrentUserUseCase
import com.pustovit.vkclient.models.user.User
import com.pustovit.vkclient.screens.navigation.ScreenNavigator
import com.pustovit.vkclient.ui_common.state.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:15
 */
class ProfileViewModel(
    private val screenNavigator: ScreenNavigator,
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
) : ViewModel() {

    private val _screenState = MutableStateFlow<ScreenState<User>>(ScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    init {
        getCurrentUserUseCase()
            .catch {
                _screenState.emit(ScreenState.Error(it.message.orEmpty()))
            }
            .onEach { user ->
                _screenState.emit(ScreenState.Data(user))
            }
            .launchIn(viewModelScope)
    }

    fun onSettingsClick() {

    }

    class Factory(
        private val screenNavigator: ScreenNavigator,
        private val getCurrentUserUseCase: GetCurrentUserUseCase,
    ) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ProfileViewModel(
                screenNavigator = screenNavigator,
                getCurrentUserUseCase = getCurrentUserUseCase,
            ) as T
        }
    }
}
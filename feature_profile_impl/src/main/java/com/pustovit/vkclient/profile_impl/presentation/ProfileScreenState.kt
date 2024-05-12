package com.pustovit.vkclient.profile_impl.presentation

import com.pustovit.vkclient.models.user.User

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:42
 */
sealed interface ProfileScreenState {

    object Loading : ProfileScreenState
    data class Data(val data: User) : ProfileScreenState
    data class Error(val errorMsg: String) : ProfileScreenState
}
package com.pustovit.vkclient.ui_common.state

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:44
 */
sealed interface ScreenState<out T : Any> {
    object Loading : ScreenState<Nothing>
    data class Data<T : Any>(val data: T) : ScreenState<T>
    data class Error(val errorMsg: String) : ScreenState<Nothing>

}
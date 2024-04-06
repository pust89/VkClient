package com.pustovit.vkclient.auth_api

import com.pustovit.vkclient.ui_common.screen.Screen

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 18:40
 */
object AuthScreen : Screen() {
    override val screenName: String
        get() = "auth"
    override val route: String
        get() = screenName
}
package com.pustovit.vkclient.navigation.screens

import com.pustovit.vkclient.ui_common.screen.Screen

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 14:26
 */
object ProfileScreen : Screen() {
    override val screenName = "profile"
    override val route: String
        get() = screenName
}
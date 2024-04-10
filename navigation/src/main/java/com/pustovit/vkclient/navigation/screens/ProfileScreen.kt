package com.pustovit.vkclient.navigation.screens

import com.pustovit.vkclient.screens.Screen

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 14:26
 */
object ProfileScreen : com.pustovit.vkclient.screens.Screen() {
    override val screenName = "profile"
    override val route: String
        get() = screenName
}
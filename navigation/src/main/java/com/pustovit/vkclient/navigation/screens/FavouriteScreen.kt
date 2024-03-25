package com.pustovit.vkclient.navigation.screens

import com.pustovit.vkclient.ui_common.screen.Screen

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 13:59
 */
object FavouriteScreen : Screen() {
    override val screenName = "favourite"

    override val route: String
        get() = screenName
}
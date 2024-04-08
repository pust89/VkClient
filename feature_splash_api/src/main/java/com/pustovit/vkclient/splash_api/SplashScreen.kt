package com.pustovit.vkclient.splash_api

import com.pustovit.vkclient.ui_common.screen.Screen

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 21:27
 */
object SplashScreen: Screen() {

    override val screenName: String
        get() = "splash"
    override val route: String
        get() = screenName
}
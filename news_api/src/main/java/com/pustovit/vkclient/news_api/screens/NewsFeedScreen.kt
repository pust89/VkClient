package com.pustovit.vkclient.news_api.screens

import com.pustovit.vkclient.ui_common.screen.Screen

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 13:58
 */
object NewsFeedScreen : Screen() {
    override val screenName = "news_feed"
    override val route: String
        get() = screenName
}
package com.pustovit.vkclient.screens

import androidx.navigation.NamedNavArgument
import com.pustovit.vkclient.screens.Screen.Companion.DASH
import com.pustovit.vkclient.screens.navigation.encodeAndAppend

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 13:52
 */
object CommentsScreen : Screen {
    override val screenName = "comments"
    const val ARG_FEED_POST_ID = "feed_post_id"
    const val ARG_FEED_POST_CONTENT_TEXT = "content_text"

    override val route: String
        get() = buildRouteWithArgs(
            ARG_FEED_POST_ID,
            ARG_FEED_POST_CONTENT_TEXT
        )

    override val arguments: List<NamedNavArgument> = buildList {
        addStringArgument(ARG_FEED_POST_ID)
        addStringArgument(ARG_FEED_POST_CONTENT_TEXT)
    }

    fun getRouteWithArgs(args: Args): String {
        return buildString {
            append(screenName)
            append(DASH)
            encodeAndAppend(args.feedPostId)
            append(DASH)
            encodeAndAppend(args.feedPostComment)
        }
    }

    data class Args(
        val feedPostId: String,
        val feedPostComment: String
    )
}
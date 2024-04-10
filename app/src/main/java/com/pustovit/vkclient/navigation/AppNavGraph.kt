package com.pustovit.vkclient.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pustovit.vkclient.auth_impl.presentation.AuthScreen
import com.pustovit.vkclient.screens.FavouriteScreen
import com.pustovit.vkclient.screens.ProfileScreen
import com.pustovit.vkclient.news_impl.presentation.comments.CommentsScreen
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsScreen
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.CommentsScreen
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.core.getDecodedString
import com.pustovit.vkclient.splash_impl.presentation.SplashScreen


@Composable
fun AppNavGraph(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = SplashScreen.route
    ) {

        composable(SplashScreen.route) { SplashScreen() }
        composable(AuthScreen.route) { AuthScreen() }
        composable(FavouriteScreen.route) { Text(text = FavouriteScreen::class.simpleName.orEmpty()) }
        composable(ProfileScreen.route) { Text(text = ProfileScreen::class.simpleName.orEmpty()) }
        composable(NewsScreen.route) { NewsScreen() }

        composable(
            route = CommentsScreen.route,
            arguments = CommentsScreen.arguments,
        ) { navBackStackEntry ->
            val args = CommentsScreen.Args(
                feedPostId = navBackStackEntry.arguments?.getInt(CommentsScreen.ARG_FEED_POST_ID)
                    ?: 99,
                feedPostComment = navBackStackEntry.arguments?.getDecodedString(CommentsScreen.ARG_FEED_POST_CONTENT_TEXT)
                    .orEmpty()
            )
            CommentsScreen(args = args)
        }


    }
}

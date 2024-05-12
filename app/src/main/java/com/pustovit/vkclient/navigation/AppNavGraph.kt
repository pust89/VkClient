package com.pustovit.vkclient.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.pustovit.vkclient.auth_impl.presentation.AuthScreen
import com.pustovit.vkclient.news_impl.presentation.comments.CommentsScreen
import com.pustovit.vkclient.news_impl.presentation.feed_posts.NewsScreen
import com.pustovit.vkclient.profile_impl.presentation.ProfileScreen
import com.pustovit.vkclient.screens.AuthScreen
import com.pustovit.vkclient.screens.CommentsScreen
import com.pustovit.vkclient.screens.FavouriteScreen
import com.pustovit.vkclient.screens.NewsScreen
import com.pustovit.vkclient.screens.ProfileScreen
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.navigation.getDecodedString
import com.pustovit.vkclient.screens.navigation.tabs.NavigationTab
import com.pustovit.vkclient.splash_impl.presentation.SplashScreen


@Composable
fun AppGraph(navHostController: NavHostController) {
    val navGraphBuilder = NavGraphBuilder(
        provider = navHostController.navigatorProvider,
        startDestination = SplashScreen.route,
        route = "app_graph"
    )

    navGraphBuilder.addOnboardingScreens()

    navGraphBuilder.addTabsNavigation()

    NavHost(
        navController = navHostController,
        graph = navGraphBuilder.build()
    )
}

fun NavGraphBuilder.addOnboardingScreens(): NavGraphBuilder {
    composable(SplashScreen.route) { SplashScreen() }
    composable(AuthScreen.route) { AuthScreen() }
    return this
}

fun NavGraphBuilder.addTabsNavigation(): NavGraphBuilder {

    navigation(
        startDestination = NewsScreen.route,
        route = NavigationTab.Home.graph.route
    ){

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


    navigation(
        startDestination = FavouriteScreen.route,
        route = NavigationTab.Favourite.graph.route
    ){
        composable(FavouriteScreen.route) { Text(text = FavouriteScreen::class.simpleName.orEmpty()) }
    }

    navigation(
        startDestination = ProfileScreen.route,
        route = NavigationTab.Profile.graph.route
    ){
        composable(ProfileScreen.route) { ProfileScreen() }
    }

    return this
}

fun NavGraphBuilder.addContentScreens(): NavGraphBuilder {
    composable(NewsScreen.route) { NewsScreen() }
    composable(FavouriteScreen.route) { Text(text = FavouriteScreen::class.simpleName.orEmpty()) }
    composable(ProfileScreen.route) { Text(text = ProfileScreen::class.simpleName.orEmpty()) }

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
    return this
}
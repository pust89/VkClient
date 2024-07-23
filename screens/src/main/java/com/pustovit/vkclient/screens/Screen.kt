package com.pustovit.vkclient.screens

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Created by Pustovit V.V.
 * Date: 25.03.2024
 * Time: 21:18
 */
sealed interface Screen {
    val screenName: String
    val route: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    fun buildRouteWithArgs(vararg arguments: String): String {
        return buildString {
            append(screenName)
            arguments.forEach { argumentName ->
                appendArgumentToRoute(argumentName)
            }
        }
    }

    fun MutableList<NamedNavArgument>.addIntArgument(
        argName: String,
        builder: NavArgumentBuilder.() -> Unit = {}
    ) {
        this += navArgument(
            argName
        ) {
            type = NavType.IntType
            builder()
        }
    }

    fun MutableList<NamedNavArgument>.addStringArgument(
        argName: String,
        builder: NavArgumentBuilder.() -> Unit = {}
    ) {
        this += navArgument(
            argName
        ) {
            type = NavType.StringType
            builder()
        }
    }

    /**
     * Add argument like "/{argName}"
     *
     * @param argName argument's name
     * @return [StringBuilder]
     */
    private fun StringBuilder.appendArgumentToRoute(argName: String): StringBuilder {
        return this.apply {
            append(DASH)
            append(LEFT_BRACE)
            append(argName)
            append(RIGHT_BRACE)
        }
    }


    companion object {
        const val DASH = "/"
        const val LEFT_BRACE = "{"
        const val RIGHT_BRACE = "}"
    }
}
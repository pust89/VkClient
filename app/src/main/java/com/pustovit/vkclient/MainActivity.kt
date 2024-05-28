package com.pustovit.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.screens.navigation.NavIntent
import com.pustovit.vkclient.ui_common.theme.AppTheme
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: MainViewModel.Factory

    private val viewModel: MainViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AppTheme {
                ContentContainer(
                    navController = navController,
                    onTabClick = viewModel::onTabClick,
                )

                SetNavigation(
                    navHostController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun SetNavigation(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {

    LaunchedEffect(true) {
        viewModel.screenFlow
            .onEach { navIntent ->
                when (navIntent) {

                    is NavIntent.NavigateTo -> {
                        navHostController.navigate(
                            route = navIntent.route,
                            navOptions = navIntent.navOptions
                        )
                    }

                    NavIntent.Back -> navHostController.popBackStack()
                    NavIntent.NavigateUp -> navHostController.navigateUp()

                    is NavIntent.BackTo -> navHostController.popBackStack(
                        route = navIntent.route,
                        inclusive = navIntent.inclusive,
                        saveState = navIntent.saveState
                    )

                }

            }.launchIn(this)
    }
}

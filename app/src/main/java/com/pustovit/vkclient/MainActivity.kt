package com.pustovit.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.navigation.AppGraph
import com.pustovit.vkclient.screens.navigation.NavIntent
import com.pustovit.vkclient.ui.ContentContainer
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

            val navHostController: NavHostController = rememberNavController()
            AppTheme {

                ContentContainer(
                    navHostController = navHostController,
                    onTabClick = viewModel::onTabClick
                )

                SetNavigation(
                    navHostController = navHostController,
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

    LaunchedEffect(key1 = 1) {
        viewModel.screenFlow
            .onEach {
                when (it) {
                    is NavIntent.NavigateTo -> {
                        navHostController.navigate(
                            route = it.route,
                            navOptions = it.navOptions
                        )
                    }

                    NavIntent.Back -> {
                        navHostController.popBackStack()
                    }

                    is NavIntent.BackTo -> {
                        navHostController.popBackStack(
                            route = it.route,
                            inclusive = it.inclusive,
                            saveState = it.saveState
                        )
                    }
                }

            }.launchIn(this)
    }
}

package com.pustovit.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pustovit.vkclient.navigation.AppGraph
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.screens.core.NavIntent
import com.pustovit.vkclient.ui_common.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
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
            AppTheme {
                val navHostController: NavHostController = rememberNavController()
                AppGraph(navHostController = navHostController)

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
        }
    }
}


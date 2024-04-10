package com.pustovit.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.pustovit.vkclient.screens.SplashScreen
import com.pustovit.vkclient.ui_common.theme.AppTheme
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
                MainContainer(screen = viewModel.screenFlow.collectAsState(initial = SplashScreen))
            }
        }
    }
}


package com.pustovit.vkclient.profile_impl.presentation.settings

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pustovit.vkclient.profile_impl.R
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponent
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponentHolder
import com.pustovit.vkclient.ui_common.compose.ErrorScreen
import com.pustovit.vkclient.ui_common.compose.LoadingScreen
import com.pustovit.vkclient.ui_common.state.ScreenState

/**
 * Created by Pustovit V.V.
 * Date: 27.05.2024
 * Time: 14:33
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserSettingsScreen() {

    val component: ProfileFeatureComponent = remember {
        ProfileFeatureComponentHolder.component
    }

    val viewModel: UserSettingsViewModel = viewModel(factory = component.userSettingsViewModelFactory())
    val state = viewModel.screenState.collectAsState()

    BackHandler {
        viewModel.onBackPressed()
    }

    when (val data = state.value) {
        ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen(errorMsg = data.errorMsg)
        is ScreenState.Data -> {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = "Settings") })
                }
            ) { paddingValues ->
                val userSettings = data.data
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { viewModel.onLogoutClick()}) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = null)

                        Text(
                            text = stringResource(R.string.exit),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
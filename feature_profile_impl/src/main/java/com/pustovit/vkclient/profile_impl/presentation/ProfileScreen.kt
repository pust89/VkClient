package com.pustovit.vkclient.profile_impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
 * Date: 12.05.2024
 * Time: 11:29
 */
@Composable
fun ProfileScreen() {

    val component: ProfileFeatureComponent = remember {
        ProfileFeatureComponentHolder.component
    }

    val viewModel: ProfileViewModel = viewModel(factory = component.profileViewModelFactory())
    val state = viewModel.screenState.collectAsState()
    when (val data = state.value) {
        ScreenState.Loading -> LoadingScreen()
        is ScreenState.Error -> ErrorScreen(errorMsg = data.errorMsg)
        is ScreenState.Data -> {
            Scaffold {paddingValues ->
                val user = data.data
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(Icons.Outlined.Build, contentDescription = null)
                    Text(text = stringResource(R.string.label_name), style = MaterialTheme.typography.labelMedium)
                    Text(text = user.name, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}


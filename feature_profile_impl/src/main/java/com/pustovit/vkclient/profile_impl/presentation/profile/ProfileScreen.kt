@file:OptIn(ExperimentalMaterial3Api::class)

package com.pustovit.vkclient.profile_impl.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pustovit.vkclient.models.user.User
import com.pustovit.vkclient.profile_impl.R
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponent
import com.pustovit.vkclient.profile_impl.di.ProfileFeatureComponentHolder
import com.pustovit.vkclient.ui_common.R_STRINGS
import com.pustovit.vkclient.ui_common.compose.ErrorScreen
import com.pustovit.vkclient.ui_common.compose.LoadingScreen
import com.pustovit.vkclient.ui_common.state.ScreenState

/**
 * Created by Pustovit V.V.
 * Date: 12.05.2024
 * Time: 11:29
 */
    //TODO Аватар
//TODO Получать и отображать больше информации о юзере
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    val component: ProfileFeatureComponent = remember {
        ProfileFeatureComponentHolder.component
    }

    val viewModel: ProfileViewModel = viewModel(factory = component.profileViewModelFactory())
    val state = viewModel.screenState.collectAsState()

    val isRefreshingState = viewModel.isRefreshing.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(R.string.you_profile)) },
                actions = {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            viewModel.onSettingsClick()
                        }
                    )
                })
        }
    ) { paddingValues ->
        when (val data = state.value) {
            ScreenState.Loading -> LoadingScreen()
            is ScreenState.Error -> ErrorScreen(errorMsg = data.errorMsg) {
                viewModel.loadUser()
            }

            is ScreenState.Data -> PullToRefreshBox(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                content = { CurrentUserScreen(user = data.data, viewModel = viewModel) },
                onRefresh = { viewModel.refresh() },
                isRefreshing = isRefreshingState.value
            )

        }

    }

}


@Composable
private fun CurrentUserScreen(
    user: User,
    viewModel: ProfileViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.Blue)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Outlined.Build, contentDescription = null)
        Text(
            text = stringResource(R_STRINGS.first_name),
            style = MaterialTheme.typography.labelMedium
        )
        Text(text = user.firstName, style = MaterialTheme.typography.titleMedium)
        Text(
            text = stringResource(R_STRINGS.last_name),
            style = MaterialTheme.typography.labelMedium
        )
        Text(text = user.lastName, style = MaterialTheme.typography.titleMedium)
    }
}
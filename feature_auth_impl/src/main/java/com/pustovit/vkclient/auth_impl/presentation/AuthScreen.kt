package com.pustovit.vkclient.auth_impl.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pustovit.vkclient.auth_impl.R
import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponent
import com.pustovit.vkclient.auth_impl.di.AuthFeatureComponentHolder
import com.vk.id.VKID
import com.vk.id.onetap.common.OneTapStyle
import com.vk.id.onetap.compose.onetap.OneTap

/**
 * Created by Pustovit V.V.
 * Date: 06.04.2024
 * Time: 19:05
 */
@Composable
fun AuthScreen() {

    val component: AuthFeatureComponent = remember {
        AuthFeatureComponentHolder.component
    }

    val viewModel: AuthViewModel = viewModel(factory = component.authViewModelFactory())

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.auth_screen_title),
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.auth_screen_body),
                    style = MaterialTheme.typography.bodyLarge
                )

                Spacer(modifier = Modifier.height(32.dp))
 
                OneTap(
                    modifier = Modifier,
                    oAuths = emptySet(),
                    style = OneTapStyle.Light(),
                    onAuth = viewModel::onAuthSuccess,
                    onFail = viewModel::onAuthFail,
                    vkid = VKID(LocalContext.current),
                    signInAnotherAccountButtonEnabled = false
                )
            }
        }
    }
}
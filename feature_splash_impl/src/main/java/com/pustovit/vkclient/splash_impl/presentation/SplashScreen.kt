package com.pustovit.vkclient.splash_impl.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pustovit.vkclient.splash_impl.R
import com.pustovit.vkclient.splash_impl.di.SplashFeatureComponent
import com.pustovit.vkclient.splash_impl.di.SplashFeatureComponentHolder

/**
 * Created by Pustovit V.V.
 * Date: 08.04.2024
 * Time: 21:44
 */
@Composable
fun SplashScreen() {

    val component: SplashFeatureComponent = remember {
        SplashFeatureComponentHolder.component
    }

    val viewModel: SplashViewModel = viewModel(factory = component.splashViewModelFactory())

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.splash_screen_title),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))

                CircularProgressIndicator()
            }
        }

    }
}
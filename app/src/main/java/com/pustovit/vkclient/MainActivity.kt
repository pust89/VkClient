package com.pustovit.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pustovit.vkclient.splash_impl.presentation.SplashScreen
import com.pustovit.vkclient.ui_common.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                SplashScreen()
            }
        }
    }
}


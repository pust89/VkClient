package com.pustovit.vkclient.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Pustovit V.V.
 * Date: 24.03.2024
 * Time: 16:35
 */
@Composable
fun LoadingScreen(paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(4.dp)
            )
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun LoadingItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(16.dp)
            )
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center), color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CircularProgressBar(
    isDisplayed: Boolean
) {
    if (isDisplayed) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.onSecondary
            )
        }
    }

}
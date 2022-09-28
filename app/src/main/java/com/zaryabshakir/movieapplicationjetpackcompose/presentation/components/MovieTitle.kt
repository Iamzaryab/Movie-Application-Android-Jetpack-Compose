package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.unit.sp

@Composable
fun MovieTitle(title: String, fontSize: Int) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = fontSize.sp,
            letterSpacing = 0.02.sp,
            fontFamily = FontFamily.Monospace,
        )
    )
}
package com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val lightThemeColors = lightColors(
    primary = primaryLight,
    primaryVariant = primaryVariantLight,
    onPrimary = Color.Black,
    secondary = secondaryLight,
    secondaryVariant = secondaryVariantLight,
    onSecondary = onSecondaryLight,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White,
)
private val darkThemeColors = darkColors(
    primary = Color(0xFF110E47),
    primaryVariant = Color(0xFF2D2F73),
    onPrimary = Color.White,
    secondary = Color(0xFFDBE3FF),
    secondaryVariant = Color(0xFFAABDFF),
    onSecondary = Color(0xFF88A4E8),
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    error = Color(0xFFB00020),
    onSurface = Color.Black,
    onError = Color.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) darkThemeColors else lightThemeColors,
        typography = CustomTypography
    ) {
        content()
    }

}



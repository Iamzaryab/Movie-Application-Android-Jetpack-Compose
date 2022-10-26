package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.util

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun shimmerAnimation(
    height: Dp,
    width: Dp,
    padding: Dp,
    colors: List<Color>,
): Brush {
    val widthPx = with(LocalDensity.current) { (width - padding).toPx() }
    val heightPx = with(LocalDensity.current) { (height - padding).toPx() }
    val gradientWidthPx = 0.3f * heightPx

    val shimmerAnimationSpecs = infiniteRepeatable<Float>(
        animation = tween(
            durationMillis = 1300,
            delayMillis = 300,
            easing = LinearEasing
        )
    )

    val infiniteTransition = rememberInfiniteTransition()
    val xPosition = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = widthPx,
        animationSpec = shimmerAnimationSpecs
    )

    val yPosition = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = heightPx,
        animationSpec = shimmerAnimationSpecs
    )

    return Brush.linearGradient(
        colors = colors,
        start = Offset(
            x = xPosition.value - gradientWidthPx,
            y = yPosition.value - gradientWidthPx
        ),
        end = Offset(
            x = xPosition.value,
            y = yPosition.value
        )
    )


}
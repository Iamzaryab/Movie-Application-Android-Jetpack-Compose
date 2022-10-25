package com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val deviceWidth: Dp = 411.42856.dp
val deviceHeight: Dp = 782.8571.dp
val figmaDesignDimen = Dimen(width = 375f, height = 734f)
val toolBarDimen = Dimen(width = 0f, height = 60f)
val nowShowingDimen = Dimen(0f, height = 320f)
val nowShowingCardDimen = Dimen(width = 143f, height = 283f)
val nowShowingImage = Dimen(width = 143f, 212f)
val popularImage = Dimen(width = 85f, 120f)

private fun calculateWidth(widthDevice: Float, width: Float): Dp {

    val percentageFigma = ((width * 100) / figmaDesignDimen.width)
    return ((percentageFigma / 100) * widthDevice).dp
}

private fun calculateHeight(heightDevice: Float, height: Float): Dp {
    val percentageFigma = ((height * 100) / figmaDesignDimen.height)
    return ((percentageFigma / 100) * heightDevice).dp

}

// Extension Function For Calculation of Width
@Composable
fun Number.dpw(): Dp {
    return calculateWidth(deviceWidth.value, toFloat())
}

// Extension Function For Calculation of Height
@Composable
fun Number.dph(): Dp {
    return calculateHeight(deviceHeight.value, toFloat())
}

data class Dimen(
    val width: Float,
    val height: Float
)
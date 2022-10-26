package com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val deviceWidth: MutableState<Dp> = mutableStateOf(0.dp)
val deviceHeight: MutableState<Dp> = mutableStateOf(0.dp)
val figmaDesignDimen = Dimen(width = 375f, height = 734f)
val toolBarDimen = Dimen(width = 0f, height = 60f)
val nowShowingDimen = Dimen(0f, height = 320f)
val nowShowingCardDimen = Dimen(width = 143f, height = 283f)
val nowShowingImage = Dimen(width = 143f, 212f)
val popularImage = Dimen(width = 85f, 120f)
val mDetailTrailer = Dimen(width = 0f, 300f)


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
    return calculateWidth(deviceWidth.value.value, toFloat())
}

// Extension Function For Calculation of Height
@Composable
fun Number.dph(): Dp {
    return calculateHeight(deviceHeight.value.value, toFloat())
}

data class Dimen(
    val width: Float,
    val height: Float
)
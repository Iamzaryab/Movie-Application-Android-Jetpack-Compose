package com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.unit.sp
import com.zaryabshakir.movieapplicationjetpackcompose.R

private val MerriWeather = FontFamily(
    Font(R.font.merriweather_light),
    Font(R.font.merriweather_regular),
    Font(R.font.merriweather_bold, weight = W900),
    Font(R.font.merriweather_black),
)
private val Mulish = FontFamily(
    Font(R.font.mulish_light),
    Font(R.font.mulish_regular),
    Font(R.font.mulish_medium),
    Font(R.font.mulish_bold),
)
val CustomTypography = Typography(

    h1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W700,
        fontSize = 20.sp,
        letterSpacing = 0.02.sp,
    ),
    h2 = TextStyle(
        fontFamily = MerriWeather,
        fontWeight = W900,
        fontSize = 16.sp,
        letterSpacing = 0.02.sp,
    ),
    h3 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W700,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.02.sp
    ),
    h4 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W600,
        fontSize = 12.sp,
        letterSpacing = 0.02.sp
    ),
    h5 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = 0.02.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = 0.02.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
    body1 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 10.sp,
        letterSpacing = 0.02.sp
    ),
    body2 = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W700,
        fontSize = 8.sp,
        letterSpacing = 0.02.sp,
    ),
    button = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
    ),
    caption = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = TextStyle(
        fontFamily = Mulish,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )

)


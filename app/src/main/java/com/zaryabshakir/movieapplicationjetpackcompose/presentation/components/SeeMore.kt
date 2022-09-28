package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.SeeMoreBorderColor
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.SeeMoreTextColor


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SeeMore(
    onClick: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, SeeMoreBorderColor),
        onClick = onClick
    ) {
        Text(
            text = "See more",
            style = TextStyle(
                color = SeeMoreTextColor,
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 8.dp)
        )
    }

}
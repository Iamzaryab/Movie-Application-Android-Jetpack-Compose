package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.GenreChipBg
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.GenreChipTextColor
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.SeeMoreBorderColor
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.SeeMoreTextColor

@Composable
fun GenreChip(genreId: Int, genres: List<Genre>) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, GenreChipBg),
        color = GenreChipBg,
    ) {
        Text(
            text = genres.find { it.id.equals(genreId) }?.name.toString(),
            style = TextStyle(
                color = GenreChipTextColor,
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp, start = 10.dp, end = 10.dp)
        )
    }
}
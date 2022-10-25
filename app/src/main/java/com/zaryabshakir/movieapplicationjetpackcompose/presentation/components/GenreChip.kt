package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import java.util.*

@Composable
fun GenreChip(genreId: Int, genres: List<Genre>) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
        color = MaterialTheme.colors.secondary,
        modifier = Modifier
            .padding(end = 8.dp)
    ) {

        Text(
            text = genres.find { it.id == genreId }?.name.toString().uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = 10.dp, end = 10.dp)
        )
    }
}
package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.RatingIconColor

@Composable
fun Rating(
    rating: Float,
    modifier: Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            Icons.Filled.Star,
            contentDescription = "Movie Rating",
            tint = RatingIconColor,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
        Text(
            text = "$rating/10 IMDb",
            modifier = Modifier
                .padding(start = 4.dp)
                .align(Alignment.CenterVertically),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.secondaryVariant

        )
    }
}

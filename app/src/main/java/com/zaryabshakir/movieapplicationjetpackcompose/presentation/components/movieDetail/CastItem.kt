package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.movieDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CastItem(url: String, name: String) {

    Column(
        modifier = Modifier.padding(end = 6.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .build(),
            contentDescription = "Logo Path",
            modifier = Modifier
                .width(82.dp)
                .height(90.dp)
                .clip(shape = RoundedCornerShape(5.dp)),
            contentScale = ContentScale.Crop

        )
        Text(
            text = name,
            modifier = Modifier
                .width(72.dp)
                .padding(top = 8.dp, bottom = 8.dp),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.primary
        )
    }
}
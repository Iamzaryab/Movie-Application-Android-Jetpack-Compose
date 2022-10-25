package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun LoadAsyncImage(
    url: String,
    pHolder: Int,
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = painterResource(id = pHolder),
        contentDescription = "poster",
        modifier = modifier,
        contentScale = contentScale
    )


}
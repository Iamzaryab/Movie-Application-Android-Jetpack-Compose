package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG

@Composable
fun NowShowingMovieCard(
    movie: Movie,
    preImageUrl: String,
    onClick: (movieId: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 6.dp, end = 6.dp, bottom = 8.dp)
            .width(150.dp)
            .height(280.dp)
            .clickable {
                Log.d(TAG, "NowShowingMovieCard: ${movie.toString()}")
                onClick(movie.id)
            },
    ) {
        val imageUrl = preImageUrl + movie.posterPath
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .height(200.dp)
                .width(150.dp),
            elevation = 8.dp
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Poster",
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = movie.originalTitle,
            modifier = Modifier.padding(top = 6.dp, start = 2.dp, end = 2.dp),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(500)
            )
        )
        Rating(
            rating = movie.voteAverage,
            modifier = Modifier.padding(top = 8.dp)
        )


    }


}
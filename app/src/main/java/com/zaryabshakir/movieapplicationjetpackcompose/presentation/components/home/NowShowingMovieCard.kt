package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.Rating
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dpw
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.nowShowingCardDimen
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.nowShowingImage
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG

@Composable
fun NowShowingMovieCard(
    movie: Movie,
    preImageUrl: String,
    onClick: (movieId: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp)
            .width(nowShowingCardDimen.width.dpw())
            .height(nowShowingCardDimen.height.dph())
            .clickable {
                onClick(movie.id)
            },
    ) {
        val imageUrl = preImageUrl + movie.posterPath
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .height(nowShowingImage.height.dph())
                .width(nowShowingImage.width.dpw()),
            elevation = 8.dp
        ) {
            BoxWithConstraints {
                Log.d(TAG, "NowShowingMovieCard: Image width $maxWidth Height $maxHeight ")
            }
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
            modifier = Modifier.padding(top = 4.dp, start = 2.dp, end = 2.dp),
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onPrimary,
            maxLines = 2
        )
        Rating(
            rating = movie.voteAverage,
            modifier = Modifier.padding(top = 8.dp)
        )


    }
}
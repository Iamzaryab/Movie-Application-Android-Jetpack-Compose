package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.GenreChip
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.Rating
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dpw
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.popularImage

@Composable
fun PopularMoviesCard(
    movie: Movie,
    preImageUrl: String,
    genres: List<Genre>,
    onClick: (movieId: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .clickable {
                onClick(movie.id)
            },
    ) {
        val imageUrl = preImageUrl + movie.posterPath
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .width(popularImage.width.dpw())
                .height(popularImage.height.dph())

        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "Movie Poster",
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onPrimary
            )
            Rating(
                rating = movie.voteAverage,
                modifier = Modifier.padding(top = 8.dp)
            )
            LazyRow(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                itemsIndexed(items = movie.genreIds) { index: Int, genreId: Int ->
                    GenreChip(genreId = genreId, genres = genres)
                }
            }


        }

    }


}
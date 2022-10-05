package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie

@Composable
fun PopularMoviesCard(
    movie: Movie,
    preImageUrl: String,
    genres: List<Genre>
) {
    Row() {
        val imageUrl = preImageUrl + movie.posterPath
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(2.dp)
                .width(100.dp)
                .height(150.dp)
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
            modifier = Modifier.padding(start = 8.dp)
        ) {
            MovieTitle(title = movie.title, fontSize = 14)
            Rating(
                rating = movie.voteAverage,
                modifier = Modifier.padding(top = 8.dp)
            )
            LazyRow() {
                itemsIndexed(items = movie.genreIds) { index: Int, genreId: Int ->
                    GenreChip(genreId = genreId, genres = genres)
                }
            }


        }

    }


}
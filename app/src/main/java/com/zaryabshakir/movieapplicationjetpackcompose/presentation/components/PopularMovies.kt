package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie

@Composable
fun PopularMovies(
    movies: List<Movie>,
    preImageUrl: String,
    genres: List<Genre>
) {
    Row(
        modifier = Modifier
            .padding(start = 6.dp, end = 18.dp)
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Text(
            text = "Popular",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight(500))
        )
        SeeMore {
            {

            }
        }
    }
    LazyColumn() {
        itemsIndexed(items = movies) { index: Int, movie: Movie ->
            PopularMoviesCard(movie, preImageUrl, genres)
        }
    }

}
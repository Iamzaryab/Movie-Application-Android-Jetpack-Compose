package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie

@Composable
fun NowShowingMovies(
    movies: List<Movie>,
    preImageUrl: String
) {
    Row(
        modifier = Modifier
            .padding(start = 6.dp, end = 18.dp)
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Text(
            text = "Now Playing",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight(500))
        )
        SeeMore {
            {

            }
        }
    }
    LazyRow() {
        itemsIndexed(items = movies) { index: Int, movie: Movie ->
            NowShowingMovieCard(movie = movie, preImageUrl = preImageUrl)
        }
    }
}
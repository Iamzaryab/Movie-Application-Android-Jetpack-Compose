package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.R
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG

@Composable
fun NowShowingMovies(
    movies: List<Movie>,
    preImageUrl: String,
    navigationController: NavController
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
    LazyRow(
    ) {
        itemsIndexed(items = movies) { index: Int, movie: Movie ->
            NowShowingMovieCard(
                movie = movie,
                preImageUrl = preImageUrl,
                onClick = {
                    val bundle = Bundle()
                    bundle.putInt("movieId", it)
                    Log.d(TAG, "NowShowingMovies: sending movie $it")
                    navigationController.navigate(R.id.moveToDetailFragment, bundle)
                }
            )
        }
    }
}
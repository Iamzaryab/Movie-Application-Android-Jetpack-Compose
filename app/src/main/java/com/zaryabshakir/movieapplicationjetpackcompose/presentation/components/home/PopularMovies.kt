package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zaryabshakir.movieapplicationjetpackcompose.R
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.CircularProgressBar
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers.PopularMoviesShimmer

@Composable
fun PopularMovies(
    movies: List<Movie>,
    preImageUrl: String,
    genres: List<Genre>,
    navigationController: NavController,
    showShimmer: Boolean,
    onItemScrollChanged: (index: Int) -> Unit,
    isLoadingMore: Boolean
) {
    //Main PopularColumn
    Column(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Popular",
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary
        )


        if (showShimmer) {
            PopularMoviesShimmer()
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(items = movies) { index: Int, movie: Movie ->
                    onItemScrollChanged(index)
                    PopularMoviesCard(
                        movie = movie,
                        preImageUrl = preImageUrl,
                        genres = genres,
                        onClick = {
                            val bundle = Bundle()
                            bundle.putInt("movieId", it)
                            navigationController.navigate(R.id.moveToDetailFragment, bundle)
                        })
                }
                if (isLoadingMore)
                    item {
                        CircularProgressBar(isDisplayed = true)
                    }
            }
        }
    }

}
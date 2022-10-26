package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home

import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.zaryabshakir.movieapplicationjetpackcompose.R
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.CircularProgressBar
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers.NowShowingMoviesShimmer
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.nowShowingDimen

@Composable
fun NowShowingMovies(
    movies: List<Movie>,
    preImageUrl: String,
    navigationController: NavController,
    showShimmer: Boolean,
    onItemScrollChanged: (index: Int) -> Unit,
    isLoadingMore: Boolean
) {
    //Main NowShowing Column
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .height(nowShowingDimen.height.dph())
    ) {
        Text(
            text = "Now Showing",
            modifier = Modifier
                .padding(start = 24.dp),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary,
        )

        //Show Shimmer if Loading
        if (showShimmer)
            NowShowingMoviesShimmer()
        else {
            //List of Now Showing Movies
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                itemsIndexed(items = movies) { index: Int, movie: Movie ->
                    onItemScrollChanged(index)
                    NowShowingMovieCard(
                        movie = movie,
                        preImageUrl = preImageUrl,
                        onClick = {
                            val bundle = Bundle()
                            bundle.putInt("movieId", it)
                            navigationController.navigate(R.id.moveToDetailFragment, bundle)
                        }
                    )
                }
                if (isLoadingMore)
                    item {
                        CircularProgressBar(isDisplayed = true)
                    }
            }
        }
    }
}
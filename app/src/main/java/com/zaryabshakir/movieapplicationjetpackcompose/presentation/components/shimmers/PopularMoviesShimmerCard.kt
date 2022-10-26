package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.util.shimmerAnimation
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.ShimmerColors
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dpw
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.popularImage

@Composable
fun PopularMoviesShimmer() {
    Column {
        repeat(3) {
            PopularMoviesShimmerCard()
        }

    }
}

@Composable
private fun PopularMoviesShimmerCard() {


    val posterBg = shimmerAnimation(
        height = popularImage.height.dph(),
        width = popularImage.width.dpw(),
        padding = 8.dp,
        colors = ShimmerColors
    )


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Surface(
            shape = MaterialTheme.shapes.small,
        ) {
            Spacer(
                modifier = Modifier
                    .width(popularImage.width.dpw())
                    .height(popularImage.height.dph())
                    .background(brush = posterBg)
            )

        }
        Column(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        ) {
            Surface(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.padding(2.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .width(100.dp)
                        .height(30.dp)
                        .background(brush = posterBg)
                )

            }
            Surface(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.padding(2.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .width(50.dp)
                        .height(20.dp)
                        .background(brush = posterBg)
                )

            }
            Surface(
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.padding(2.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .width(150.dp)
                        .height(25.dp)
                        .background(brush = posterBg)
                )

            }

        }


    }
}
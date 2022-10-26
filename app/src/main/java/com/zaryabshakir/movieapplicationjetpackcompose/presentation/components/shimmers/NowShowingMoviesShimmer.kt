package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.util.shimmerAnimation
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dpw
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.nowShowingCardDimen
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.nowShowingImage


@Composable
fun NowShowingMoviesShimmer() {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        repeat(3) {
            NowShowingMovieCardShimmer()
        }

    }
}


@Composable
private fun NowShowingMovieCardShimmer() {

    val background = shimmerAnimation(
        height = nowShowingCardDimen.height.dph(),
        width = nowShowingCardDimen.width.dpw(),
        padding = 5.dp,
        colors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.9f)
        )
    )
    Column(
        modifier = Modifier
            .padding(start = 16.dp)
            .width(nowShowingCardDimen.width.dpw())
            .height(nowShowingCardDimen.height.dph())

    ) {
        Surface(shape = MaterialTheme.shapes.small) {
            Spacer(
                modifier = Modifier
                    .width(nowShowingImage.width.dpw())
                    .height(nowShowingImage.height.dph())
                    .background(brush = background)
            )
        }
        Spacer(modifier = Modifier.padding(top = 4.dp))
        Surface(
            shape = MaterialTheme.shapes.small,
        ) {
            Spacer(
                modifier = Modifier
                    .width(nowShowingImage.width.dpw() - 20.dp)
                    .height(20.dp)
                    .background(brush = background)
            )
        }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
        ) {
            Spacer(
                modifier = Modifier
                    .width(nowShowingImage.width.dpw() - 40.dp)
                    .height(15.dp)
                    .background(brush = background)
            )
        }

    }
}
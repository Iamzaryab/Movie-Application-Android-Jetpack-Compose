package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.movieDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zaryabshakir.movieapplicationjetpackcompose.R
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.GenreChip
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.Rating
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.mDetailTrailer


@Composable
fun MovieDetailComponent(
    movieDetail: MovieDetail?,
    casts: List<Cast>,
    preImageUrl: String
) {

    movieDetail?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
        ) {
            item {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (mTrailer, mDetail) = createRefs()
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(mTrailer) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        val (playButton, playText, bgPoster) = createRefs()
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(preImageUrl + movieDetail.backdropPath)
                                .crossfade(true)
                                .build(),
                            contentDescription = "poster",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(mDetailTrailer.height.dph())
                                .constrainAs(bgPoster) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                },
                            contentScale = ContentScale.Crop
                        )
                        Image(
                            painter = painterResource(id = R.drawable.play_button),
                            contentDescription = "play button",
                            modifier = Modifier
                                .height(45.dp)
                                .width(45.dp)
                                .constrainAs(playButton) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom)
                                },
                        )
                        Text(
                            text = "Play Trailer",
                            modifier = Modifier
                                .padding(8.dp)
                                .constrainAs(playText) {
                                    top.linkTo(playButton.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                },
                            style = MaterialTheme.typography.h4,
                            color = Color.White
                        )


                    }
                    Surface(
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .constrainAs(mDetail) {
                                top.linkTo(
                                    anchor = mTrailer.bottom,
                                    margin = (-20).dp
                                )
                            },
                    ) {
                        Column(
                            modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)
                        ) {
                            Text(
                                text = movieDetail.originalTitle,
                                style = MaterialTheme.typography.h1,
                                color = MaterialTheme.colors.onPrimary
                            )
                            Rating(
                                rating = movieDetail.voteAverage,
                                Modifier.padding(top = 8.dp)
                            )
                            LazyRow(
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                itemsIndexed(items = movieDetail.genres) { index: Int, genre: Genre ->
                                    GenreChip(genreId = genre.id, genres = movieDetail.genres)
                                }
                            }
                            OtherDetails()

                            Text(
                                text = "Description",
                                modifier = Modifier.padding(top = 20.dp),
                                style = MaterialTheme.typography.h2,
                                color = MaterialTheme.colors.primary
                            )
                            Text(
                                text = movieDetail.overview?.let {
                                    movieDetail.overview
                                }
                                    ?: "",
                                modifier = Modifier.padding(top = 8.dp),
                                style = MaterialTheme.typography.subtitle1,
                                color = MaterialTheme.colors.secondaryVariant,
                                lineHeight = 22.sp
                            )
                            Text(
                                text = "Cast",
                                modifier = Modifier.padding(top = 20.dp),
                                style = MaterialTheme.typography.h2,
                                color = MaterialTheme.colors.primary
                            )
                            LazyRow(modifier = Modifier.padding(top = 20.dp)) {
                                itemsIndexed(items = casts) { index: Int, cast: Cast ->
                                    CastItem(
                                        url = preImageUrl + cast.profilePath,
                                        name = cast.name
                                    )
                                }


                            }

                            Spacer(modifier = Modifier.fillMaxHeight())

                        }


                    }


                }
            }
        }

    }

}
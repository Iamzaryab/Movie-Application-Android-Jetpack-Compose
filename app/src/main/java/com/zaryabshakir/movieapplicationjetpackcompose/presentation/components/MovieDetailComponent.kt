package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components

import android.util.Log
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.network.responses.CastsResponse
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG


@Composable
fun MovieDetailComponent(
    movieDetail: MovieDetail?,
    casts: List<Cast>,
    preImageUrl: String
) {

    movieDetail?.let {
        ConstraintLayout(
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
                        .height(300.dp)
                        .constrainAs(bgPoster) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop
                )
                Icon(
                    imageVector = Icons.Rounded.PlayCircle,
                    contentDescription = "play button",
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)
                        .constrainAs(playButton) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        },
                    tint = Color.White,

                    )
                Text(
                    text = "Play Trailer",
                    modifier = Modifier.constrainAs(playText) {
                        top.linkTo(playButton.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    style = TextStyle(fontSize = 14.sp, color = Color.White)
                )


            }

            Card(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .constrainAs(mDetail) {
                        top.linkTo(
                            anchor = mTrailer.bottom,
                            margin = -50.dp
                        )
                    },
                elevation = 10.dp
            ) {
                Column(
                    modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)
                ) {
                    Text(
                        text = movieDetail.originalTitle,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight(700)
                        )
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
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Length")
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "2h 38 mins"
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Language")
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "English"
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Rating")
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "18+"
                            )
                        }

                    }

                    Text(
                        text = "Description",
                        modifier = Modifier.padding(top = 20.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700)
                        )
                    )
                    Text(
                        text = movieDetail.overview?.let { movieDetail.overview } ?: "",
                        modifier = Modifier.padding(top = 8.dp),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            lineHeight = 22.sp,
                            letterSpacing = 0.02.sp
                        )
                    )
                    Text(
                        text = "Cast",
                        modifier = Modifier.padding(top = 20.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(700)
                        )
                    )
                    LazyRow(modifier = Modifier.padding(top = 20.dp)) {
                        itemsIndexed(items = casts) { index: Int, cast: Cast ->
                            Column(
                                modifier = Modifier.padding(end = 6.dp)
                            ) {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(preImageUrl + cast.profilePath)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "Logo Path",
                                    modifier = Modifier
                                        .width(72.dp)
                                        .height(110.dp)
                                        .clip(shape = RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop

                                )
                                Text(
                                    text = cast.name,
                                    modifier = Modifier.width(72.dp),
                                    style = TextStyle(fontSize = 12.sp)
                                )
                            }
                        }


                    }

                }


            }


        }
    }

}
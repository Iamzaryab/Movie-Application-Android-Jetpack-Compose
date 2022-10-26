package com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.zaryabshakir.movieapplicationjetpackcompose.R
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.util.shimmerAnimation
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.deviceHeight
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.deviceWidth
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.dph
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.mDetailTrailer

@Composable
fun MovieDetailShimmer() {


    val mDetailShimmer = shimmerAnimation(
        height = deviceHeight.value,
        width = deviceWidth.value,
        padding = 5.dp,
        colors = listOf(
            Color.LightGray.copy(alpha = 0.9f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.9f)
        )
    )
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
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(mDetailTrailer.height.dph())
                    .constrainAs(bgPoster) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .background(mDetailShimmer),
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
                Surface(shape = MaterialTheme.shapes.small) {
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                            .width(deviceWidth.value / 2)
                            .background(mDetailShimmer)
                    )
                }
                Surface(
                    modifier = Modifier.padding(top = 8.dp),
                    shape = MaterialTheme.shapes.small
                ) {
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(deviceWidth.value / 3)
                            .background(mDetailShimmer)

                    )

                }
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    repeat(3) {
                        Surface(
                            modifier = Modifier.padding(end = 8.dp),
                            shape = RoundedCornerShape(18.dp)
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .height(15.dp)
                                    .width(50.dp)
                                    .background(mDetailShimmer)

                            )

                        }
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
                        Text(
                            text = "Length",
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.secondaryVariant
                        )
                        Surface(
                            modifier = Modifier.padding(top = 4.dp, end = 12.dp),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .height(15.dp)
                                    .fillMaxWidth()
                                    .background(mDetailShimmer)
                            )
                        }

                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Language",
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.secondaryVariant
                        )
                        Surface(
                            modifier = Modifier.padding(top = 4.dp, end = 12.dp),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .height(15.dp)
                                    .fillMaxWidth()
                                    .background(mDetailShimmer)
                            )
                        }

                    }
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Rating",
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.secondaryVariant
                        )
                        Surface(
                            modifier = Modifier.padding(top = 4.dp, end = 12.dp),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Spacer(
                                modifier = Modifier
                                    .height(15.dp)
                                    .fillMaxWidth()
                                    .background(mDetailShimmer)
                            )
                        }

                    }

                }

                Text(
                    text = "Description",
                    modifier = Modifier.padding(top = 20.dp),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primary
                )
                Surface(
                    modifier = Modifier.padding(top = 8.dp),
                    shape = MaterialTheme.shapes.small
                ) {
                    Column() {
                        repeat(3) {
                            Spacer(
                                modifier = Modifier
                                    .padding(bottom = 4.dp)
                                    .height(12.dp)
                                    .fillMaxWidth()
                                    .background(mDetailShimmer)
                            )
                        }


                    }
                }
                Text(
                    text = "Cast",
                    modifier = Modifier.padding(top = 20.dp),
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.primary
                )
                Row(modifier = Modifier.padding(top = 20.dp)) {
                    repeat(4) {
                        Column(
                            modifier = Modifier.padding(end = 6.dp)
                        ) {
                            Surface(
                                shape = MaterialTheme.shapes.small
                            ) {
                                Spacer(
                                    modifier = Modifier
                                        .height(90.dp)
                                        .width(82.dp)
                                        .background(mDetailShimmer)
                                )
                            }
                            Surface(
                                shape = MaterialTheme.shapes.small
                            ) {
                                Spacer(
                                    modifier = Modifier
                                        .padding(top = 8.dp, bottom = 8.dp)
                                        .height(12.dp)
                                        .width(70.dp)
                                        .background(mDetailShimmer)
                                )
                            }
                        }
                    }

                }
//                LazyRow(modifier = Modifier.padding(top = 20.dp)) {
//                    itemsIndexed(items = casts) { index: Int, cast: Cast ->
//                        CastItem(
//                            url = preImageUrl + cast.profilePath,
//                            name = cast.name
//                        )
//                    }
//
//
//                }

                Spacer(modifier = Modifier.fillMaxHeight())

            }


        }


    }

}
package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.movieDetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.MovieDetailComponent
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private var movieId: Int? = null
    private val viewModel: MovieDetailViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("movieId")?.let { movieId ->
            this.movieId = movieId
            viewModel.getMovie(movieId)
            viewModel.getCasts(movieId)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            val movieDetail: MovieDetail? = viewModel.movieDetail.value
            val casts: List<Cast> = viewModel.casts.value
            setContent {
                MovieDetailComponent(
                    movieDetail = movieDetail,
                    preImageUrl = viewModel.preImgUrl,
                    casts = casts
                )
            }
        }
    }
}
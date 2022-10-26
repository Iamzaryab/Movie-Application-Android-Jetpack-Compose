package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.movieDetail.MovieDetailComponent
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.shimmers.MovieDetailShimmer
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

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
            setContent {
                AppTheme(darkTheme = false) {
                    val movieDetail: MovieDetail? = viewModel.movieDetail.value
                    val casts: List<Cast> = viewModel.casts.value
                    val loading = viewModel.loading.value
                    if (loading)
                        MovieDetailShimmer()
                    else
                        MovieDetailComponent(
                            movieDetail = movieDetail,
                            preImageUrl = viewModel.preImgUrl,
                            casts = casts
                        )
                }

            }
        }
    }
}
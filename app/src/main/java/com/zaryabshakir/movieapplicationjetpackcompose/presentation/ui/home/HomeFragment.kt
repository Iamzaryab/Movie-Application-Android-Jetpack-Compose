package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.NowShowingMovies
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.PopularMovies
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val nowShowingMovies = viewModel.nowPlayingMovies
                val popularMovies = viewModel.popularMovies
                Log.d(TAG, "onCreateView: " + popularMovies.value)
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    /**
                     * ToolBar
                     */
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Movie Application")
                    }
                    /**
                     * Now Showing Movies
                     */
                    NowShowingMovies(
                        movies = nowShowingMovies.value,
                        preImageUrl = viewModel.preImgUrl,
                        findNavController()
                    )
                    /**
                     * Popular Movies
                     */
                    PopularMovies(
                        movies = nowShowingMovies.value,
                        preImageUrl = viewModel.preImgUrl,
                        viewModel.genreList.value
                    )

                }
            }
        }
    }
}
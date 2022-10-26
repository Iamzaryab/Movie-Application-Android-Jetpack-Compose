package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.ToolBar
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home.NowShowingMovies
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.components.home.PopularMovies
import com.zaryabshakir.movieapplicationjetpackcompose.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme(
                    darkTheme = viewModel.darkTheme.value,
                ) {
                    val nowShowingMovies = viewModel.nowShowingMovies
                    val popularMovies = viewModel.popularMovies
                    val isNowShowingLoading = viewModel.isNowShowingLoading.value
                    val isNowShowingLoadingMore = viewModel.isNowShowingLoadingMore.value
                    val isPopularLoading = viewModel.isPopularLoading.value
                    val isPopularLoadingMore = viewModel.isPopularLoadingMore.value
                    val nowShowingPage = viewModel.nowShowingPage.value
                    val popularPage = viewModel.popularPage.value
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        /**
                         * ToolBar
                         */
                        ToolBar(
                            darkTheme = viewModel.darkTheme.value,
                            onToggleDarkTheme = viewModel::onToggleDarkTheme
                        )
                        /**
                         * Now Showing Movies
                         */
                        NowShowingMovies(
                            movies = nowShowingMovies.value,
                            preImageUrl = viewModel.preImgUrl,
                            navigationController = findNavController(),
                            showShimmer = isNowShowingLoading,
                            onItemScrollChanged = {
                                viewModel.onChangeNowShowingScrollPosition(it)
                                if ((it + 1) >= (nowShowingPage * PAGE_SIZE) && !isNowShowingLoadingMore) {
                                    viewModel.nextNowShowingPage()
                                }
                            },
                            isLoadingMore = isNowShowingLoadingMore
                        )

                        /**
                         * Popular Movies
                         */
                        PopularMovies(
                            movies = popularMovies.value,
                            preImageUrl = viewModel.preImgUrl,
                            genres = viewModel.genreList.value,
                            navigationController = findNavController(),
                            showShimmer = isPopularLoading,
                            onItemScrollChanged = {
                                viewModel.onChangePopularScrollPosition(it)
                                if ((it + 1) >= (popularPage * PAGE_SIZE) && !isPopularLoadingMore) {
                                    viewModel.nextPopularPage()
                                }
                            },
                            isLoadingMore = isPopularLoadingMore
                        )
                    }

                }


            }
        }
    }
}
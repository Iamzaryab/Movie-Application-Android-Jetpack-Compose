package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.repository.MovieRepository
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

const val PAGE_SIZE = 20

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository,
    @Named("api_key") private val apiKey: String,
    @Named("pre_image_url") val preImgUrl: String
) : ViewModel() {
    val nowShowingMovies: MutableState<List<Movie>> = mutableStateOf(listOf())
    val popularMovies: MutableState<List<Movie>> = mutableStateOf(listOf())
    val genreList: MutableState<List<Genre>> = mutableStateOf(listOf())
    val isNowShowingLoading: MutableState<Boolean> = mutableStateOf(false)
    val isNowShowingLoadingMore: MutableState<Boolean> = mutableStateOf(false)
    val isPopularLoading: MutableState<Boolean> = mutableStateOf(false)
    val isPopularLoadingMore: MutableState<Boolean> = mutableStateOf(false)
    val darkTheme: MutableState<Boolean> = mutableStateOf(false)

    val nowShowingPage = mutableStateOf(1)
    private var nowShowingScrollPosition = 0

    val popularPage = mutableStateOf(1)
    private var popularScrollPosition = 0

    init {
        getPopularMovies()
        getNowShowingMovies()
        getGenre()
    }

    /**
     * Getting NowShowing Movies
     */
    private fun getNowShowingMovies() {
        viewModelScope.launch {
            isNowShowingLoading.value = true
            delay(2000)
            nowShowingMovies.value = movieRepository.getMovies("now_playing", 1, apiKey)
            isNowShowingLoading.value = false
        }
    }

    /**
     * Getting PopularMovies
     */
    private fun getPopularMovies() {
        viewModelScope.launch {
            isPopularLoading.value = true
            delay(5000)
            popularMovies.value = movieRepository.getMovies("top_rated", 1, apiKey)
            isPopularLoading.value = false
        }
    }

    /**
     * Getting List of Genres
     */
    private fun getGenre() {
        viewModelScope.launch {
            genreList.value = movieRepository.genre(apiKey)
        }
    }


    fun nextNowShowingPage() {
        viewModelScope.launch {

            //prevent duplicate events
            if ((nowShowingScrollPosition + 1) >= (nowShowingPage.value * PAGE_SIZE)) {
                isNowShowingLoadingMore.value = true
                incrementNowShowingPage()
                delay(2000)
                if (nowShowingPage.value > 1) {
                    val result = movieRepository.getMovies(
                        type = "now_playing",
                        page = nowShowingPage.value,
                        apiKey = apiKey
                    )
                    appendNowShowingMovies(result)
                }
                isNowShowingLoadingMore.value = false

            }
        }
    }


    fun nextPopularPage() {
        viewModelScope.launch {
            //prevent duplicate events
            if ((popularScrollPosition + 1) >= (popularPage.value * PAGE_SIZE)) {
                isPopularLoadingMore.value = true
                incrementPopularPage()
                delay(2000)
                if (popularPage.value > 1) {
                    val result = movieRepository.getMovies(
                        type = "popular",
                        page = popularPage.value,
                        apiKey = apiKey
                    )

                    appendPopularMovies(result)
                }
                isPopularLoadingMore.value = false

            }
        }
    }


    /**
     * Append new NowShowing Movies to already List
     */
    private fun appendNowShowingMovies(movies: List<Movie>) {
        val current = ArrayList(this.nowShowingMovies.value)
        current.addAll(movies)
        this.nowShowingMovies.value = current
    }

    /**
     * Append new Popular Movies to already List
     */
    private fun appendPopularMovies(movies: List<Movie>) {
        val current = ArrayList(this.popularMovies.value)
        current.addAll(movies)
        this.popularMovies.value = current
    }

    private fun incrementNowShowingPage() {
        nowShowingPage.value++
    }

    private fun incrementPopularPage() {
        popularPage.value++
    }

    fun onChangeNowShowingScrollPosition(position: Int) {
        nowShowingScrollPosition = position
    }

    fun onChangePopularScrollPosition(position: Int) {
        popularScrollPosition = position
    }

    fun onToggleDarkTheme() {
        Log.d(TAG, "onToggleDarkTheme: Toggle Theme Clicked ${darkTheme.value}")
        darkTheme.value = !darkTheme.value
    }


}
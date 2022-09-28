package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository,
    @Named("api_key") private val apiKey: String,
    @Named("pre_image_url")  val preImgUrl: String
) : ViewModel() {
    val nowPlayingMovies: MutableState<List<Movie>> = mutableStateOf(listOf())
    val popularMovies: MutableState<List<Movie>> = mutableStateOf(listOf())
    val genreList: MutableState<List<Genre>> = mutableStateOf(listOf())

    init {
        getMovies("now_playing")
        getMovies("top_rated")
        getGenre()
    }

    fun getMovies(type: String) {
        viewModelScope.launch {
            when (type) {
                "now_playing" -> nowPlayingMovies.value = movieRepository.getMovies(type, 1, apiKey)
                "top_rated" -> nowPlayingMovies.value = movieRepository.getMovies(type, 1, apiKey)
            }
        }
    }

    fun getGenre() {
        viewModelScope.launch {
            genreList.value = movieRepository.genre(apiKey)
        }
    }
}
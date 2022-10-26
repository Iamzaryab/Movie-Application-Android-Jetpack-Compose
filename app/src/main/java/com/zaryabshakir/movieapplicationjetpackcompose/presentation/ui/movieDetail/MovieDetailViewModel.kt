package com.zaryabshakir.movieapplicationjetpackcompose.presentation.ui.movieDetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MovieDetailViewModel
@Inject
constructor(
    private val movieRepository: MovieRepository,
    @Named("api_key") private val apiKey: String,
    @Named("pre_image_url") val preImgUrl: String
) : ViewModel() {
    val movieDetail: MutableState<MovieDetail?> = mutableStateOf(null)
    val casts: MutableState<List<Cast>> = mutableStateOf(listOf())
    val loading: MutableState<Boolean> = mutableStateOf(false)
     fun getMovie(id: Int) {
        viewModelScope.launch {
            loading.value = true
            movieDetail.value = movieRepository.getMoviesDetail(id, apiKey)
            loading.value = false
        }

    }

    fun getCasts(id: Int) {
        viewModelScope.launch {
            casts.value = movieRepository.getCasts(id, apiKey)
        }
    }

}
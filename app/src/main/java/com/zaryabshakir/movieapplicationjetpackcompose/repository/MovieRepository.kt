package com.zaryabshakir.movieapplicationjetpackcompose.repository

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail

interface MovieRepository {
    suspend fun getMovies(type: String, page: Int, apiKey: String): List<Movie>
    suspend fun genre(apiKey: String): List<Genre>
    suspend fun getMoviesDetail(id: Int, apiKey: String): MovieDetail
    suspend fun getCasts(id: Int, apiKey: String): List<Cast>

}
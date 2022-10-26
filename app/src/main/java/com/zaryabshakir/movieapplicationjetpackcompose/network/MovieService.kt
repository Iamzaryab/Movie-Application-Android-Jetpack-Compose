package com.zaryabshakir.movieapplicationjetpackcompose.network

import com.zaryabshakir.movieapplicationjetpackcompose.network.model.MovieDetailDto
import com.zaryabshakir.movieapplicationjetpackcompose.network.responses.CastsResponse
import com.zaryabshakir.movieapplicationjetpackcompose.network.responses.GenresResponse
import com.zaryabshakir.movieapplicationjetpackcompose.network.responses.MoviesResponse
import retrofit2.http.Path
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/{type}")
    suspend fun getMovies(
        @Path("type") type: String,
        @Query("page") page: Int,
        @Query("api_key") key: String
    ): MoviesResponse

    @GET("genre/movie/list")
    suspend fun genre(
        @Query("api_key") key: String
    ): GenresResponse

    @GET("movie/{id}")
    suspend fun get(
        @Path("id") id: Int,
        @Query("api_key") key: String
    ): MovieDetailDto

    @GET("movie/{movie_id}/credits")
    suspend fun getCasts(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String
    ): CastsResponse
}
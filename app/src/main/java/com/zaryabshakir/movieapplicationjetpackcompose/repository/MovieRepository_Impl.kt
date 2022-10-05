package com.zaryabshakir.movieapplicationjetpackcompose.repository

import android.util.Log
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.network.MovieService
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.CastDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.GenreDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.MovieDetailDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.MovieDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.util.TAG

class MovieRepository_Impl(
    private val movieService: MovieService,
    private val movieDtoMapper: MovieDtoMapper,
    private val movieDetailDtoMapper: MovieDetailDtoMapper,
    private val genreDtoMapper: GenreDtoMapper,
    private val castDtoMapper: CastDtoMapper
) : MovieRepository {
    override suspend fun getMovies(type: String, page: Int, apiKey: String): List<Movie> {
        return movieDtoMapper.toDomainList(movieService.getMovies(type, page, apiKey).results)
    }

    override suspend fun genre(apiKey: String): List<Genre> {
        return genreDtoMapper.toDomainList(movieService.genre(apiKey).genres)
    }

    override suspend fun getMoviesDetail(id: Int, apiKey: String): MovieDetail {
        return movieDetailDtoMapper.mapToDomainModel(movieService.get(id, apiKey))
    }

    override suspend fun getCasts(id: Int, apiKey: String): List<Cast> {
        return castDtoMapper.toDomainList(movieService.getCasts(id, apiKey).cast)
    }


}

package com.zaryabshakir.movieapplicationjetpackcompose.di

import com.zaryabshakir.movieapplicationjetpackcompose.network.MovieService
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.CastDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.GenreDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.MovieDetailDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.MovieDtoMapper
import com.zaryabshakir.movieapplicationjetpackcompose.repository.MovieRepository
import com.zaryabshakir.movieapplicationjetpackcompose.repository.MovieRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieService: MovieService,
        movieDtoMapper: MovieDtoMapper,
        movieDetailDtoMapper: MovieDetailDtoMapper,
        genreDtoMapper: GenreDtoMapper,
        castDtoMapper: CastDtoMapper
    ): MovieRepository {
        return MovieRepository_Impl(
            movieService, movieDtoMapper, movieDetailDtoMapper, genreDtoMapper, castDtoMapper
        )
    }
}
package com.zaryabshakir.movieapplicationjetpackcompose.di

import com.google.gson.GsonBuilder
import com.zaryabshakir.movieapplicationjetpackcompose.network.MovieService
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesMovieService(): MovieService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideMoviesMapper(): MovieDtoMapper {
        return MovieDtoMapper()
    }

    @Singleton
    @Provides
    fun provideGenreMapper(): GenreDtoMapper {
        return GenreDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCasts(): CastDtoMapper {
        return CastDtoMapper()
    }

    @Singleton
    @Provides
    fun provideMovieDetailMapper(): MovieDetailDtoMapper {
        return MovieDetailDtoMapper(
            belongToCollectionDtoMapper = BelongToCollectionDtoMapper(),
            genreDtoMapper = GenreDtoMapper(),
            spokenLanguagesDtoMapper = SpokenLanguagesDtoMapper(),
            productionCountriesDtoMapper = ProductionCountriesDtoMapper(),
            productionCompaniesDtoMapper = ProductionCompaniesDtoMapper(),)
    }

    @Singleton
    @Provides
    @Named("api_key")
    fun provideApiKey(): String {
        return "0e7274f05c36db12cbe71d9ab0393d47"
    }

    @Singleton
    @Provides
    @Named("pre_image_url")
    fun providePreImageUrl(): String {
        return "https://image.tmdb.org/t/p/w500"
    }

}
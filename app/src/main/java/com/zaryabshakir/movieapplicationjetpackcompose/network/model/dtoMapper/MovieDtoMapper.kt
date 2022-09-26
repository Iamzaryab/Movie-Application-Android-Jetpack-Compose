package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Movie
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.MovieDto

/**
 * Models Mapper
 */
class MovieDtoMapper : DomainMapper<MovieDto, Movie> {
    /**
     * Mapping Domain Model 'Movie' to Network Model 'MovieDto'
     */
    override fun mapToDomainModel(model: MovieDto): Movie {
        return Movie(
            adult = model.adult,
            backdrop_path = model.backdrop_path,
            genreIds = model.genre_ids,
            id = model.id,
            originalLanguage = model.original_language,
            originalTitle = model.original_title,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = model.poster_path,
            releaseDate = model.release_date,
            title = model.title,
            video = model.video,
            voteAverage = model.vote_average,
            voteCount = model.vote_count
        )
    }

    /**
     * Mapping Network model 'MovieDto' to Domain Model 'Movie'
     */
    override fun mapFromDomainModel(domainModel: Movie): MovieDto {
        return MovieDto(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdrop_path,
            genre_ids = domainModel.genreIds,
            id = domainModel.id,
            original_language = domainModel.originalLanguage,
            original_title = domainModel.originalTitle,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.posterPath,
            release_date = domainModel.releaseDate,
            title = domainModel.title,
            video = domainModel.video,
            vote_average = domainModel.voteAverage,
            vote_count = domainModel.voteCount
        )
    }

    /**
     * Mapping a Network model 'MovieDto' List to Domain Model 'Movie' List
     */
    fun toDomainList(initial: List<MovieDto>): List<Movie> {
        return initial.map { mapToDomainModel(it) }
    }

    /**
     * Mapping a Domain Model 'Movie' List to Network Model 'MovieDto' List
     */
    fun fromDomainList(initial: List<Movie>): List<MovieDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
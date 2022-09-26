package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.MovieDetail
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.MovieDetailDto


class MovieDetailDtoMapper(
    private val belongToCollectionDtoMapper: BelongToCollectionDtoMapper,
    private val productionCompaniesDtoMapper: ProductionCompaniesDtoMapper,
    private val productionCountriesDtoMapper: ProductionCountriesDtoMapper,
    private val spokenLanguagesDtoMapper: SpokenLanguagesDtoMapper,
    private val genreDtoMapper: GenreDtoMapper
) : DomainMapper<MovieDetailDto, MovieDetail> {
    override fun mapToDomainModel(model: MovieDetailDto): MovieDetail {
        return MovieDetail(
            adult = model.adult,
            backdropPath = model.backdrop_path,
            belongsToCollection = belongToCollectionDtoMapper.mapToDomainModel(model.belongs_to_collection),
            budget = model.budget,
            genres = genreDtoMapper.toDomainList(model.genres),
            homepage = model.homepage,
            id = model.id,
            imdbId = model.imdb_id,
            originalLanguage = model.original_language,
            originalTitle = model.original_title,
            overview = model.overview,
            popularity = model.popularity,
            posterPath = model.poster_path,
            productionCompanies = productionCompaniesDtoMapper.toDomainList(model.production_companies),
            productionCountries = productionCountriesDtoMapper.toDomainList(model.production_countries),
            releaseDate = model.release_date,
            revenue = model.revenue,
            runtime = model.runtime,
            spokenLanguages = spokenLanguagesDtoMapper.toDomainList(model.spoken_languages),
            status = model.status,
            tagline = model.tagline,
            video = model.video,
            voteAverage = model.vote_average,
            voteCount = model.vote_count
        )
    }

    override fun mapFromDomainModel(domainModel: MovieDetail): MovieDetailDto {
        return MovieDetailDto(
            adult = domainModel.adult,
            backdrop_path = domainModel.backdropPath,
            belongs_to_collection = belongToCollectionDtoMapper.mapFromDomainModel(domainModel.belongsToCollection),
            budget = domainModel.budget,
            genres = genreDtoMapper.fromDomainList(domainModel.genres),
            homepage = domainModel.homepage,
            id = domainModel.id,
            imdb_id = domainModel.imdbId,
            original_language = domainModel.originalLanguage,
            original_title = domainModel.originalTitle,
            overview = domainModel.overview,
            popularity = domainModel.popularity,
            poster_path = domainModel.posterPath,
            production_companies = productionCompaniesDtoMapper.fromDomainList(domainModel.productionCompanies),
            production_countries = productionCountriesDtoMapper.fromDomainList(domainModel.productionCountries),
            release_date = domainModel.releaseDate,
            revenue = domainModel.revenue,
            runtime = domainModel.runtime,
            spoken_languages = spokenLanguagesDtoMapper.fromDomainList(domainModel.spokenLanguages),
            status = domainModel.status,
            tagline = domainModel.tagline,
            video = domainModel.video,
            vote_average = domainModel.voteAverage,
            vote_count = domainModel.voteCount
        )
    }
}
package com.zaryabshakir.movieapplicationjetpackcompose.domain.model


data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String?,
    val belongsToCollection: BelongToCollection?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    val imdbId: String?,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Float,
    val posterPath: String?,
    val productionCompanies: List<ProductionCompanies>,
    val productionCountries: List<ProductionCountries>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguages>,
    val status: String,
    val tagline: String?,
    val video: Boolean,
    val voteAverage: Float,
    val voteCount: Int
)


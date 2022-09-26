package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Genre
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.GenreDto


class GenreDtoMapper : DomainMapper<GenreDto, Genre> {
    override fun mapToDomainModel(model: GenreDto): Genre {
        return Genre(
            id = model.id,
            name = model.name
        )
    }

    override fun mapFromDomainModel(domainModel: Genre): GenreDto {
        return GenreDto(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun toDomainList(initial: List<GenreDto>): List<Genre> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Genre>): List<GenreDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
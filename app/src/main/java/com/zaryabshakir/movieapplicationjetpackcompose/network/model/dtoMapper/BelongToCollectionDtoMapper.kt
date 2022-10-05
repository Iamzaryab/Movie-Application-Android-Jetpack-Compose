package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.BelongToCollection
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.BelongToCollectionDto


class BelongToCollectionDtoMapper : DomainMapper<BelongToCollectionDto, BelongToCollection> {
    override fun mapToDomainModel(model: BelongToCollectionDto): BelongToCollection{
        return BelongToCollection(
            id = model.id,
            name = model.name,
            posterPath = model.poster_path,
            backdropPath = model.backdrop_path
        )
    }

    override fun mapFromDomainModel(domainModel: BelongToCollection): BelongToCollectionDto{
        return BelongToCollectionDto(
            id = domainModel.id,
            name = domainModel.name,
            poster_path = domainModel.posterPath,
            backdrop_path = domainModel.backdropPath
        )
    }
}
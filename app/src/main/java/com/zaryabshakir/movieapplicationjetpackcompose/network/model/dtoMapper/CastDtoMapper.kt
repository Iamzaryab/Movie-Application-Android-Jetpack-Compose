package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.Cast
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.CastDto

class CastDtoMapper : DomainMapper<CastDto, Cast> {
    override fun mapToDomainModel(model: CastDto): Cast {
        return Cast(
            id = model.id,
            name = model.name,
            originalName = model.original_name,
            profilePath = model.profile_path
        )
    }

    override fun mapFromDomainModel(domainModel: Cast): CastDto {
        return CastDto(
            id = domainModel.id,
            name = domainModel.name,
            original_name = domainModel.originalName,
            profile_path = domainModel.profilePath
        )
    }

    fun fromDomainList(initial: List<Cast>): List<CastDto> {
        return initial.map { mapFromDomainModel(it) }
    }

    fun toDomainList(initial: List<CastDto>): List<Cast> {
        return initial.map { mapToDomainModel(it) }
    }

}
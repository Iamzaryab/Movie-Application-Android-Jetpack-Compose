package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.SpokenLanguages
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.SpokenLanguagesDto


class SpokenLanguagesDtoMapper : DomainMapper<SpokenLanguagesDto, SpokenLanguages> {
    override fun mapToDomainModel(model: SpokenLanguagesDto): SpokenLanguages {
        return SpokenLanguages(
            englishName = model.english_name,
            iso_639_1 = model.iso_639_1,
            name = model.name
        )
    }

    override fun mapFromDomainModel(domainModel: SpokenLanguages): SpokenLanguagesDto {
        return SpokenLanguagesDto(
            english_name = domainModel.englishName,
            iso_639_1 = domainModel.iso_639_1,
            name = domainModel.name
        )
    }

    fun toDomainList(initial: List<SpokenLanguagesDto>): List<SpokenLanguages> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<SpokenLanguages>): List<SpokenLanguagesDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
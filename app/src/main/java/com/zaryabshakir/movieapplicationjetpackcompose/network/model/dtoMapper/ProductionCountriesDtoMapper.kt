package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.ProductionCountries
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.ProductionCountriesDto


class ProductionCountriesDtoMapper : DomainMapper<ProductionCountriesDto, ProductionCountries> {
    override fun mapToDomainModel(model: ProductionCountriesDto): ProductionCountries {
        return ProductionCountries(
            iso_3166_1 = model.iso_3166_1,
            name = model.name
        )

    }

    override fun mapFromDomainModel(domainModel: ProductionCountries): ProductionCountriesDto {
        return ProductionCountriesDto(
            iso_3166_1 = domainModel.iso_3166_1,
            name = domainModel.name
        )
    }

    fun toDomainList(initial: List<ProductionCountriesDto>): List<ProductionCountries> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<ProductionCountries>): List<ProductionCountriesDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}
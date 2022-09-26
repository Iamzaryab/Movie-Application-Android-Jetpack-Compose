package com.zaryabshakir.movieapplicationjetpackcompose.network.model.dtoMapper

import com.zaryabshakir.movieapplicationjetpackcompose.domain.model.ProductionCompanies
import com.zaryabshakir.movieapplicationjetpackcompose.domain.util.DomainMapper
import com.zaryabshakir.movieapplicationjetpackcompose.network.model.ProductionCompaniesDto


class ProductionCompaniesDtoMapper : DomainMapper<ProductionCompaniesDto, ProductionCompanies> {
    override fun mapToDomainModel(model: ProductionCompaniesDto): ProductionCompanies {
        return ProductionCompanies(
            id = model.id,
            logoPath = model.logo_path,
            name = model.name,
            originCountry = model.origin_country
        )
    }

    override fun mapFromDomainModel(domainModel: ProductionCompanies): ProductionCompaniesDto {
        return ProductionCompaniesDto(
            id = domainModel.id,
            logo_path = domainModel.logoPath,
            name = domainModel.name,
            origin_country = domainModel.originCountry
        )
    }

    fun toDomainList(initial: List<ProductionCompaniesDto>): List<ProductionCompanies> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<ProductionCompanies>): List<ProductionCompaniesDto> {
        return initial.map { mapFromDomainModel(it) }
    }

}
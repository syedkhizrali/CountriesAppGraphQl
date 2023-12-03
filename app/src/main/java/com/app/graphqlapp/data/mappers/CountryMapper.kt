package com.app.graphqlapp.data.mappers

import com.app.graphqlapp.CountriesQuery
import com.app.graphqlapp.CountryQuery
import com.app.graphqlapp.domain.dto.CountryDetailDto
import com.app.graphqlapp.domain.dto.CountryDto

fun CountryQuery.Country.toDetailedCountry(): CountryDetailDto{
    return CountryDetailDto(
        name = name,
        code = code ,
        emoji = emoji,
        capital = capital ?: "",
        currency = currency ?: "",
        languages = languages.map { it.name },
        continent = continent.name,
    )
}

fun CountriesQuery.Country.toCountry(): CountryDto{
    return CountryDto(
        name = name,
        code = code ,
        emoji = emoji,
        capital = capital ?: ""
    )
}

package com.app.graphqlapp.domain.usecase

import com.app.graphqlapp.domain.CountryClient
import com.app.graphqlapp.domain.dto.CountryDto

class GetCountryUseCse(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<CountryDto> {
        return countryClient
            .getCountry()
            .sortedBy {
                it.name
            }
    }
}
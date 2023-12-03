package com.app.graphqlapp.domain.usecase

import com.app.graphqlapp.domain.CountryClient
import com.app.graphqlapp.domain.dto.CountryDetailDto
import com.app.graphqlapp.domain.dto.CountryDto

class GetCountryDetailUseCse(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): CountryDetailDto? {
        return countryClient.getCountryDetails(code)
    }
}
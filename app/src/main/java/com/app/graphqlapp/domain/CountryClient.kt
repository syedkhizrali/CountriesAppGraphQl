package com.app.graphqlapp.domain

import com.app.graphqlapp.CountryQuery
import com.app.graphqlapp.domain.dto.CountryDetailDto
import com.app.graphqlapp.domain.dto.CountryDto

interface CountryClient {
    suspend fun getCountry(): List<CountryDto>
    suspend fun getCountryDetails(code: String): CountryDetailDto?
}
package com.app.graphqlapp.data

import com.apollographql.apollo3.ApolloClient
import com.app.graphqlapp.CountriesQuery
import com.app.graphqlapp.CountryQuery
import com.app.graphqlapp.data.mappers.toCountry
import com.app.graphqlapp.data.mappers.toDetailedCountry
import com.app.graphqlapp.domain.CountryClient
import com.app.graphqlapp.domain.dto.CountryDetailDto
import com.app.graphqlapp.domain.dto.CountryDto
import javax.inject.Inject


class ApolloCountryClient (private val apolloClient: ApolloClient): CountryClient {
    override suspend fun getCountry(): List<CountryDto> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map{
                it.toCountry()
            }
            ?: emptyList()
    }

    override suspend fun getCountryDetails(code: String): CountryDetailDto? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}
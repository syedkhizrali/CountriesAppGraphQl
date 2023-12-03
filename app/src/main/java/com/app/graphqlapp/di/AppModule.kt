package com.app.graphqlapp.di

import com.apollographql.apollo3.ApolloClient
import com.app.graphqlapp.data.ApolloCountryClient
import com.app.graphqlapp.domain.CountryClient
import com.app.graphqlapp.domain.usecase.GetCountryDetailUseCse
import com.app.graphqlapp.domain.usecase.GetCountryUseCse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApolloClient(): ApolloClient{
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun providesCountryClient(apolloClient: ApolloClient): CountryClient{
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun providesGetCountryUseCse(countryClient: CountryClient): GetCountryUseCse{
        return GetCountryUseCse(countryClient)
    }

    @Provides
    @Singleton
    fun providesGetCountryDetailUseCse(countryClient: CountryClient): GetCountryDetailUseCse{
        return GetCountryDetailUseCse(countryClient)
    }

}
package com.app.graphqlapp.domain.dto

import java.util.Currency

data class CountryDetailDto(
    val name: String,
    val code: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
)

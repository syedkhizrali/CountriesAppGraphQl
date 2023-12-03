package com.app.graphqlapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.graphqlapp.presentation.CountryViewModel
import com.app.graphqlapp.presentation.screens.CountryScreen
import com.app.graphqlapp.ui.theme.GraphQlAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlAppTheme {
                val viewModel = hiltViewModel<CountryViewModel>()
                val state by viewModel.state.collectAsState()
                CountryScreen(
                    state = state,
                    onSelectCountry = viewModel::countryDetail,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}
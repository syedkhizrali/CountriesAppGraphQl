package com.app.graphqlapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.graphqlapp.domain.dto.CountryDetailDto
import com.app.graphqlapp.domain.dto.CountryDto
import com.app.graphqlapp.domain.usecase.GetCountryDetailUseCse
import com.app.graphqlapp.domain.usecase.GetCountryUseCse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getCountryUseCse: GetCountryUseCse,
    private val getCountryDetailUseCse: GetCountryDetailUseCse): ViewModel() {

        private val _state = MutableStateFlow(CountryState())
        val state = _state.asStateFlow()

        init{
            viewModelScope.launch {
                _state.update {
                    it.copy(
                        isLoading = true
                    )
                }
                _state.update {
                    it.copy(
                        countries = getCountryUseCse.execute(),
                        isLoading = false
                    )
                }
            }
        }

    fun countryDetail(code: String){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCountry = getCountryDetailUseCse.execute(code)
                )
            }
        }
    }

    fun dismissCountryDialog(){
        _state.update {
            it.copy(
                selectedCountry = null
            )
        }
    }


        data class CountryState(
            val countries: List<CountryDto> = emptyList(),
            val isLoading: Boolean = false,
            val selectedCountry: CountryDetailDto? = null
        )

}
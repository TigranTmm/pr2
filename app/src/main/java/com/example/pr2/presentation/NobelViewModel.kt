package com.example.pr2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr2.data.NobelApi
import com.example.pr2.data.repository.NobelRepositoryImpl
import com.example.pr2.di.NetworkModule
import com.example.pr2.domain.usecase.GetNobelPrizesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NobelViewModel : ViewModel() {

    private val repository =
        NobelRepositoryImpl(
            NobelApi(NetworkModule.client)
        )

    private val useCase =
        GetNobelPrizesUseCase(repository)

    private val _state =
        MutableStateFlow(NobelState())

    val state = _state.asStateFlow()

    init {
        loadPrizes()
    }

    fun loadPrizes(
        year: String? = null,
        category: String? = null
    ) {

        viewModelScope.launch {

            _state.value =
                NobelState(isLoading = true)

            try {

                val prizes =
                    useCase(year, category)

                _state.value =
                    NobelState(prizes = prizes)

            } catch (e: Exception) {

                _state.value =
                    NobelState(
                        error = e.message ?: "Error"
                    )
            }
        }
    }
}
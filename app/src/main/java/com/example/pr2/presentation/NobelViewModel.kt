package com.example.pr2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr2.data.RetrofitInstance
import com.example.pr2.data.repository.NobelRepositoryImpl
import com.example.pr2.domain.model.Prize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NobelViewModel : ViewModel() {

    private val repo = NobelRepositoryImpl(RetrofitInstance.api)

    var state = MutableStateFlow<List<Prize>>(emptyList())
        private set

    fun loadPrizes() {

        viewModelScope.launch {

            val result = repo.getPrizes()
            state.value = result
        }
    }

    fun addFavorite(id: Int) {

        viewModelScope.launch {
            repo.addFavorite(id)
        }
    }
}
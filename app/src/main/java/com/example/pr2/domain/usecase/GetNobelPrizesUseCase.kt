package com.example.pr2.domain.usecase

import com.example.pr2.domain.repository.NobelRepository

class GetPrizesUseCase(
    private val repository: NobelRepository
) {
    suspend operator fun invoke() = repository.getPrizes()
}
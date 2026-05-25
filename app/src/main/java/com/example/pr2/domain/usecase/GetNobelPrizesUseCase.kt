package com.example.pr2.domain.usecase

import com.example.pr2.domain.repository.NobelRepository

class GetNobelPrizesUseCase(
    private val repository: NobelRepository
) {

    suspend operator fun invoke(
        year: String?,
        category: String?
    ) = repository.getPrizes(year, category)
}
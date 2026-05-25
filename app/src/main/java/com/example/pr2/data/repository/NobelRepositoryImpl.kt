package com.example.pr2.data.repository

import com.example.pr2.data.NobelApi
import com.example.pr2.data.toDomain
import com.example.pr2.domain.model.NobelPrize
import com.example.pr2.domain.repository.NobelRepository

class NobelRepositoryImpl(
    private val api: NobelApi
) : NobelRepository {

    override suspend fun getPrizes(
        year: String?,
        category: String?
    ): List<NobelPrize> {

        return api.getPrizes(year, category)
            .nobelPrizes
            .flatMap { it.toDomain() }
    }
}

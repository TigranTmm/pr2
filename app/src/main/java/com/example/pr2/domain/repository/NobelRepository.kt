package com.example.pr2.domain.repository

import com.example.pr2.domain.model.NobelPrize

interface NobelRepository {

    suspend fun getPrizes(
        year: String?,
        category: String?
    ): List<NobelPrize>
}
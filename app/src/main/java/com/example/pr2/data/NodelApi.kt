package com.example.pr2.data

import com.example.pr2.data.dto.NobelResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class NobelApi(
    private val client: HttpClient
) {

    suspend fun getPrizes(
        year: String?,
        category: String?
    ): NobelResponseDto {

        return client.get(
            "https://api.nobelprize.org/2.1/nobelPrizes"
        ) {

            parameter("limit", 25)

            if (!year.isNullOrBlank()) {
                parameter("nobelPrizeYear", year)
            }

            if (!category.isNullOrBlank()) {
                parameter("nobelPrizeCategory", category)
            }

        }.body()
    }
}
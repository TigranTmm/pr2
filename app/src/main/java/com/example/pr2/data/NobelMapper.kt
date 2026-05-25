package com.example.pr2.data

import com.example.pr2.data.dto.NobelPrizeDto
import com.example.pr2.domain.model.NobelPrize

fun NobelPrizeDto.toDomain(): List<NobelPrize> {

    return laureates?.map {

        NobelPrize(
            id = it.id,
            year = awardYear,
            category = category.en,
            fullName = it.knownName?.en ?: "Unknown",
            motivation = it.motivation?.en ?: "",
            birthPlace = it.birth?.place?.city?.en ?: "Unknown",
            imageUrl = null
        )

    } ?: emptyList()
}
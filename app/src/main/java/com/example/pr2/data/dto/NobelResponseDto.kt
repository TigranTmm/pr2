package com.example.pr2.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class NobelResponseDto(
    val nobelPrizes: List<NobelPrizeDto>
)

@Serializable
data class NobelPrizeDto(
    val awardYear: String,
    val category: CategoryDto,
    val laureates: List<LaureateDto>? = null
)

@Serializable
data class CategoryDto(
    val en: String
)

@Serializable
data class LaureateDto(
    val id: String,
    val knownName: KnownNameDto? = null,
    val motivation: MotivationDto? = null,
    val birth: BirthDto? = null,
    val wikipedia: WikipediaDto? = null
)

@Serializable
data class KnownNameDto(
    val en: String
)

@Serializable
data class MotivationDto(
    val en: String
)

@Serializable
data class BirthDto(
    val place: PlaceDto? = null
)

@Serializable
data class PlaceDto(
    val city: CityDto? = null
)

@Serializable
data class CityDto(
    val en: String
)

@Serializable
data class WikipediaDto(
    val english: String? = null
)
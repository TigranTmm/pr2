package com.example.pr2.domain.model

data class NobelPrize(

    val id: String,

    val year: String,

    val category: String,

    val fullName: String,

    val motivation: String,

    val birthPlace: String,

    val imageUrl: String?
)

package com.example.pr2.presentation

import com.example.pr2.domain.model.NobelPrize

data class NobelState(

    val isLoading: Boolean = false,

    val prizes: List<NobelPrize> = emptyList(),

    val error: String = ""
)

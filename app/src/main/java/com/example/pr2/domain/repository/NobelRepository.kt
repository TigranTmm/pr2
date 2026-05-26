package com.example.pr2.domain.repository

import com.example.pr2.domain.model.NobelPrize
import com.example.pr2.domain.model.Prize

interface NobelRepository {

    suspend fun login(username: String, password: String): String?

    suspend fun getPrizes(): List<Prize>

    suspend fun getFavorites(): List<Prize>

    suspend fun addFavorite(id: Int)

    suspend fun removeFavorite(id: Int)
}
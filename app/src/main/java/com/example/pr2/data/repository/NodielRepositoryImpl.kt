package com.example.pr2.data.repository

import com.example.pr2.data.ApiService
import com.example.pr2.data.SessionManager
import com.example.pr2.domain.model.LoginRequest
import com.example.pr2.domain.model.Prize
import com.example.pr2.domain.repository.NobelRepository

class NobelRepositoryImpl(
    private val api: ApiService
) : NobelRepository {

    override suspend fun login(username: String, password: String): String? {

        val response = api.login(LoginRequest(username, password))

        return if (response.isSuccessful) {
            response.body()?.token
        } else null
    }

    override suspend fun getPrizes(): List<Prize> {

        val response = api.getPrizes(SessionManager.token ?: "")

        return response.body() ?: emptyList()
    }

    override suspend fun getFavorites(): List<Prize> {

        val response = api.getFavorites(SessionManager.token ?: "")

        return response.body() ?: emptyList()
    }

    override suspend fun addFavorite(id: Int) {

        api.addFavorite(SessionManager.token ?: "", id)
    }

    override suspend fun removeFavorite(id: Int) {

        api.removeFavorite(SessionManager.token ?: "", id)
    }
}
package com.example.pr2.data

import com.example.pr2.domain.model.LoginRequest
import com.example.pr2.domain.model.Prize
import com.example.pr2.domain.model.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<TokenResponse>

    @GET("prizes")
    suspend fun getPrizes(
        @Header("Authorization") token: String
    ): Response<List<Prize>>

    @GET("users/me/prizes")
    suspend fun getFavorites(
        @Header("Authorization") token: String
    ): Response<List<Prize>>

    @POST("users/me/prizes/{id}")
    suspend fun addFavorite(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<Unit>

    @DELETE("users/me/prizes/{id}")
    suspend fun removeFavorite(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<Unit>
}
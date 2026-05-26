package com.example.pr2.domain.model

data class LoginRequest(
    val username: String,
    val password: String
)

data class TokenResponse(
    val token: String
)

data class Prize(
    val id: Int,
    val awardYear: Int,
    val category: String,
    val fullName: String,
    val motivation: String
)
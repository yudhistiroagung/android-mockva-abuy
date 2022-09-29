package com.yudhistiroagung.mockva.domain.authentication.repository

import com.yudhistiroagung.mockva.domain.authentication.model.LoginData

interface AuthenticationRepository {
    suspend fun login(email: String, password: String): LoginData
}
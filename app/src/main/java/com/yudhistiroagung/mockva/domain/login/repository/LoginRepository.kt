package com.yudhistiroagung.mockva.domain.login.repository

import com.yudhistiroagung.mockva.domain.login.model.LoginData

interface LoginRepository {
    suspend fun login(email: String, password: String): LoginData
}
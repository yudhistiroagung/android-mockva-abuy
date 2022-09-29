package com.yudhistiroagung.mockva.data.authentication.source

import com.yudhistiroagung.mockva.data.authentication.model.LoginResponse

interface AuthenticationDataSource {
    suspend fun login(email: String, password: String): LoginResponse
}
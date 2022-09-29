package com.yudhistiroagung.mockva.data.authentication.source

import com.yudhistiroagung.mockva.domain.authentication.model.LoginData
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository

class AuthenticationRepositoryImpl constructor(
    private val loginDataSource: AuthenticationDataSource
): AuthenticationRepository {
    override suspend fun login(email: String, password: String): LoginData {
        TODO("Not yet implemented")
    }
}
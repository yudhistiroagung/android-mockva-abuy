package com.yudhistiroagung.mockva.data.authentication.source

import com.yudhistiroagung.mockva.data.cache.AuthManager
import com.yudhistiroagung.mockva.domain.authentication.model.LoginData
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository

class AuthenticationRepositoryImpl constructor(
    private val loginDataSource: AuthenticationDataSource,
    private val authManager: AuthManager
) : AuthenticationRepository {

    override suspend fun login(email: String, password: String): LoginData {
        val sessionId = loginDataSource.login(email, password).sessionId

        authManager.setSessionId(sessionId)

        return LoginData(sessionId)
    }
}
package com.yudhistiroagung.mockva.data.authentication.source

import com.yudhistiroagung.mockva.data.cache.AuthManager
import com.yudhistiroagung.mockva.di.module.DataSourceModule
import com.yudhistiroagung.mockva.domain.authentication.model.LoginData
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    @DataSourceModule.NetworkDataSource private val authNetworkDataSource: AuthenticationDataSource,
    private val authManager: AuthManager
) : AuthenticationRepository {

    override suspend fun login(email: String, password: String): LoginData {
        val result = authNetworkDataSource.login(email, password)
        return with(result) {
            authManager.setSessionId(sessionId)
            authManager.setAccountId(accountId)
            LoginData(sessionId, accountId)
        }
    }
}
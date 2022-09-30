package com.yudhistiroagung.mockva.data.authentication.source.network

import com.yudhistiroagung.mockva.data.authentication.model.LoginPayload
import com.yudhistiroagung.mockva.data.authentication.model.LoginResponse
import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationDataSource
import javax.inject.Inject

class AuthenticationNetworkDataSource @Inject constructor(
    private val authenticationApi: AuthenticationApi
): AuthenticationDataSource {

    override suspend fun login(email: String, password: String): LoginResponse {
        return authenticationApi.login(LoginPayload(email, password))
    }
}
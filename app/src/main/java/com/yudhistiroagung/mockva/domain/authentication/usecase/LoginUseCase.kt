package com.yudhistiroagung.mockva.domain.authentication.usecase

import com.yudhistiroagung.mockva.domain.common.usecase.BaseUseCase
import com.yudhistiroagung.mockva.domain.authentication.model.LoginRequest
import com.yudhistiroagung.mockva.domain.authentication.model.LoginData
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthenticationRepository
): BaseUseCase<LoginData, LoginRequest>() {
    override suspend fun run(params: LoginRequest): LoginData {
        return with(params) {
            authRepository.login(username, password)
        }
    }
}
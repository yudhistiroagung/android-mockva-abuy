package com.yudhistiroagung.mockva.domain.login.usecase

import com.yudhistiroagung.mockva.domain.common.usecase.BaseUseCase
import com.yudhistiroagung.mockva.domain.login.model.LoginRequest
import com.yudhistiroagung.mockva.domain.login.model.LoginData
import com.yudhistiroagung.mockva.domain.login.repository.LoginRepository

class LoginUseCase constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<LoginData, LoginRequest>() {
    override suspend fun run(params: LoginRequest): LoginData {
        return with(params) {
            loginRepository.login(email, password)
        }
    }
}
package com.yudhistiroagung.mockva.domain.login.usecase

import com.yudhistiroagung.mockva.domain.common.usecase.BaseUseCase
import com.yudhistiroagung.mockva.domain.login.model.LoginBody
import com.yudhistiroagung.mockva.domain.login.model.LoginData
import com.yudhistiroagung.mockva.domain.login.repository.LoginRepository

class LoginUseCase constructor(
    private val loginRepository: LoginRepository
): BaseUseCase<LoginData, LoginBody>() {
    override suspend fun run(params: LoginBody): LoginData {
        return with(params) {
            loginRepository.login(email, password)
        }
    }
}
package com.yudhistiroagung.mockva.data.login.source

import com.yudhistiroagung.mockva.domain.login.model.LoginData
import com.yudhistiroagung.mockva.domain.login.repository.LoginRepository

class LoginRepositoryImpl: LoginRepository {
    override suspend fun login(email: String, password: String): LoginData {
        TODO("Not yet implemented")
    }
}
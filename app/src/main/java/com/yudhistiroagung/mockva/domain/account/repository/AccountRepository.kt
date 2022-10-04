package com.yudhistiroagung.mockva.domain.account.repository

import com.yudhistiroagung.mockva.domain.account.model.Account

interface AccountRepository {
    suspend fun getAccountDetail(): Account
}
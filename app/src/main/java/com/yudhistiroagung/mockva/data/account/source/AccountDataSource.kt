package com.yudhistiroagung.mockva.data.account.source

import com.yudhistiroagung.mockva.data.account.model.AccountResponse

interface AccountDataSource {
    suspend fun getAccountDetail(accountId: String): AccountResponse
}
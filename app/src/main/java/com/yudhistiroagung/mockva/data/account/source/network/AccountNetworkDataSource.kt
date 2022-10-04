package com.yudhistiroagung.mockva.data.account.source.network

import com.yudhistiroagung.mockva.data.account.model.AccountResponse
import com.yudhistiroagung.mockva.data.account.source.AccountDataSource
import javax.inject.Inject

class AccountNetworkDataSource @Inject constructor(
    private val accountApi: AccountApi
): AccountDataSource {

    override suspend fun getAccountDetail(accountId: String): AccountResponse {
        return accountApi.getAccountDetail(accountId)
    }
}
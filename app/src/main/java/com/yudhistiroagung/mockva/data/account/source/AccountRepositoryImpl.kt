package com.yudhistiroagung.mockva.data.account.source

import com.yudhistiroagung.mockva.data.account.mapper.AccountResponseMapper
import com.yudhistiroagung.mockva.data.cache.AuthManager
import com.yudhistiroagung.mockva.di.module.DataSourceModule
import com.yudhistiroagung.mockva.domain.account.model.Account
import com.yudhistiroagung.mockva.domain.account.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    @DataSourceModule.NetworkDataSource private val accountDataSource: AccountDataSource,
    private val authManager: AuthManager,
    private val accountResponseMapper: AccountResponseMapper
): AccountRepository {
    override suspend fun getAccountDetail(): Account {
        val accountId = authManager.getAccountId()
        return accountDataSource
            .getAccountDetail(accountId ?: "")
            .run(accountResponseMapper::map)
    }
}
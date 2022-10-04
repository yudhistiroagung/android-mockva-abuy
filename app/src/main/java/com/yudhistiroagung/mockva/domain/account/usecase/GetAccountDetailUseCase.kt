package com.yudhistiroagung.mockva.domain.account.usecase

import com.yudhistiroagung.mockva.domain.account.model.Account
import com.yudhistiroagung.mockva.domain.account.repository.AccountRepository
import com.yudhistiroagung.mockva.domain.common.usecase.BaseUseCase
import javax.inject.Inject

class GetAccountDetailUseCase @Inject constructor(
    private val accountRepository: AccountRepository
): BaseUseCase<Account, BaseUseCase.None>() {

    override suspend fun run(params: None): Account {
        return accountRepository.getAccountDetail()
    }
}
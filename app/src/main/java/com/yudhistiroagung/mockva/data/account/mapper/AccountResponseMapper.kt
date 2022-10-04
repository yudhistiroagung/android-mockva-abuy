package com.yudhistiroagung.mockva.data.account.mapper

import com.yudhistiroagung.mockva.data.account.model.AccountResponse
import com.yudhistiroagung.mockva.data.common.mapper.BaseMapper
import com.yudhistiroagung.mockva.domain.account.model.Account
import javax.inject.Inject

class AccountResponseMapper @Inject constructor(): BaseMapper<AccountResponse, Account>() {
    override fun map(input: AccountResponse): Account {
        return with(input) {
            Account(
                id,
                name,
                username,
                balance
            )
        }
    }
}
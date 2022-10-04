package com.yudhistiroagung.mockva.data.account.source.network

import com.yudhistiroagung.mockva.data.account.model.AccountResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AccountApi {
    @GET("rest/account/detail")
    suspend fun getAccountDetail(@Query("id") accountId: String): AccountResponse
}
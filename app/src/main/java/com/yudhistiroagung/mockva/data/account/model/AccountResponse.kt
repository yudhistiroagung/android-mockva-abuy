package com.yudhistiroagung.mockva.data.account.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AccountResponse(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("username")
    val username: String,
    @SerialName("balance")
    val balance: Double,
)
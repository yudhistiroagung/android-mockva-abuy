package com.yudhistiroagung.mockva.data.authentication.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class LoginPayload(
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String
)

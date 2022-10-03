package com.yudhistiroagung.mockva.data.authentication.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName("id")
    val sessionId: String,
)

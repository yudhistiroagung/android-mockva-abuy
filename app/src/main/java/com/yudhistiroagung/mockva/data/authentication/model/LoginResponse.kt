package com.yudhistiroagung.mockva.data.authentication.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerializedName("_sessionId")
    val sessionId: String,
)

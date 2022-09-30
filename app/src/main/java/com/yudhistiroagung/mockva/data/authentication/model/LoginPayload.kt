package com.yudhistiroagung.mockva.data.authentication.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class LoginPayload(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)

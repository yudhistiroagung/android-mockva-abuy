package com.yudhistiroagung.mockva.data.authentication.source.network

import com.yudhistiroagung.mockva.data.authentication.model.LoginPayload
import com.yudhistiroagung.mockva.data.authentication.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("rest/auth/login")
    suspend fun login(@Body payload: LoginPayload): LoginResponse

}
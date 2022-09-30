package com.yudhistiroagung.mockva.data.common.interceptor

import com.yudhistiroagung.mockva.data.cache.AuthManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class SessionInterceptor @Inject constructor(
    private val authManager: AuthManager
): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            val sessionId = authManager.getSessionId()
            sessionId?.also {
                addHeader("_sessionId", it)
            }
        }

        return chain.proceed(builder.build())
    }
}
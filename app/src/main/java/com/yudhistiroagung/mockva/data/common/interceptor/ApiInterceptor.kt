package com.yudhistiroagung.mockva.data.common.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

const val APIKEY = "6aa6160d-2720-4080-8673-5dbb482d4fe"
const val SECRET = "2c68m66b9j97b2ffptvxebjy9vov5f8lhgk93g5jhgkqx4i58524o3j713cit3xz"
const val ENCODED = "NmFhNjE2MGQtMjcyMC00MDgwLTg2NzMtNWRiYjQ4MmQ0ZmU6MmM2OG02NmI5ajk3YjJmZnB0dnhlYmp5OXZvdjVmOGxoZ2s5M2c1amhna3F4NGk1ODUyNG8zajcxM2NpdDN4eg=="

class ApiInterceptor @Inject constructor(): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            addHeader("Authorization", "BASIC $ENCODED")
        }

        return chain.proceed(builder.build())
    }
}
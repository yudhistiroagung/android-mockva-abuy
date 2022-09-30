package com.yudhistiroagung.mockva.di.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.yudhistiroagung.mockva.BuildConfig
import com.yudhistiroagung.mockva.data.authentication.source.network.AuthenticationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @ExperimentalSerializationApi
    @Singleton
    fun provideAuthenticationApi(
        @NetworkModule.BasicAuthOkHttpClient okHttpClient: OkHttpClient,
        retrofitBuilder: Retrofit.Builder,
        json: Json
    ): AuthenticationApi {
        val contentType = "application/json".toMediaType()
        return retrofitBuilder
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build().create(AuthenticationApi::class.java)
    }

}
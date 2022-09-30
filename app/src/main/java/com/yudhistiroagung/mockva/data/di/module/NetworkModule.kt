package com.yudhistiroagung.mockva.data.di.module

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import com.yudhistiroagung.mockva.BuildConfig
import com.yudhistiroagung.mockva.data.common.interceptor.ApiInterceptor
import com.yudhistiroagung.mockva.data.common.interceptor.SessionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class BasicAuthOkHttpClient

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class SessionAuthOkHttpClient

    @Singleton
    @Provides
    fun provideRetrofitBuilder() = Retrofit.Builder()

    @Provides
    @Singleton
    @BasicAuthOkHttpClient
    fun provideBasicAuthInterceptor(
        debugInterceptors: MutableList<Interceptor>,
        apiInterceptor: ApiInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        debugInterceptors.forEach(::addInterceptor)
        addInterceptor(apiInterceptor)
    }.build()

    @Provides
    @Singleton
    @SessionAuthOkHttpClient
    fun provideSessionAuthInterceptor(
        debugInterceptors: MutableList<Interceptor>,
        apiInterceptor: ApiInterceptor,
        sessionInterceptor: SessionInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {
        debugInterceptors.forEach(::addInterceptor)
        addInterceptor(apiInterceptor)
        addInterceptor(sessionInterceptor)
    }.build()

    @Singleton
    @Provides
    fun provideDebugInterceptor(context: Context): MutableList<Interceptor> {
        return mutableListOf<Interceptor>(
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        ).apply { if (BuildConfig.DEBUG) add(ChuckInterceptor(context)) }
    }

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

}
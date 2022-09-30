package com.yudhistiroagung.mockva.di.module

import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationDataSource
import com.yudhistiroagung.mockva.data.authentication.source.network.AuthenticationNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NetworkDataSource

    @Binds
    @Singleton
    @NetworkDataSource
    abstract fun bindAuthenticationNetworkDataSource(
        authenticationDataSource: AuthenticationNetworkDataSource
    ): AuthenticationDataSource

}
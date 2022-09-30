package com.yudhistiroagung.mockva.di.module

import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationDataSource
import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationRepositoryImpl
import com.yudhistiroagung.mockva.data.cache.AuthManager
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(
        @DataSourceModule.NetworkDataSource authNetworkDataSource: AuthenticationDataSource,
        authManager: AuthManager
    ): AuthenticationRepository {
        return AuthenticationRepositoryImpl(authNetworkDataSource, authManager)
    }
}

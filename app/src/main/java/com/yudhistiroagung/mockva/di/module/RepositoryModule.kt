package com.yudhistiroagung.mockva.di.module

import com.yudhistiroagung.mockva.data.account.source.AccountRepositoryImpl
import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationRepositoryImpl
import com.yudhistiroagung.mockva.domain.account.repository.AccountRepository
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository

    @Binds
    @Singleton
    abstract fun provideAccountRepository(
        accountRepositoryImpl: AccountRepositoryImpl
    ): AccountRepository
}

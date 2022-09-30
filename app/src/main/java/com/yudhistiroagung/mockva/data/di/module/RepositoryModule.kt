package com.yudhistiroagung.mockva.data.di.module

import com.yudhistiroagung.mockva.data.authentication.source.AuthenticationRepositoryImpl
import com.yudhistiroagung.mockva.domain.authentication.repository.AuthenticationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository
}
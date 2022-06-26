package com.example.diexample

import com.example.diexample.login.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object UserModule {

    @Provides
    fun provideUserRepository(): IUserRepository {
        return UserRepository(provideUserLocalDataSource(), provideUserRemoteDataSource())
    }

    @Provides
    fun provideUserLocalDataSource(): IUserLocalDataSource {
        return UserLocalDataSource()
    }

    @Provides
    fun provideUserRemoteDataSource(): IUserRemoteDataSource {
        return UserRemoteDataSource(provideLoginService())
    }

    @Provides
    fun provideLoginService(): ILoginService {
        return LoginRetrofitService()
    }
}
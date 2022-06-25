package com.example.diexample.login.model

class UserRepository(
    private val localDataSource: IUserLocalDataSource,
    private val remoteDataSource: IUserRemoteDataSource): IUserRepository {
}
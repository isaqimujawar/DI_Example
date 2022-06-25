package com.example.diexample.container

import com.example.diexample.login.model.LoginRetrofitService
import com.example.diexample.login.model.UserLocalDataSource
import com.example.diexample.login.model.UserRemoteDataSource
import com.example.diexample.login.model.UserRepository

class AppContainer {
    // First, create retrofit which is the dependency of UserRemoteDataSource
    private val retrofit = LoginRetrofitService()

    // Then, satisfy the dependencies of UserRepository
    private val localDataSource = UserLocalDataSource()
    private val remoteDataSource = UserRemoteDataSource(retrofit)

    // Now you can create an instance of UserRepository that LoginViewModel needs
    val userRepository = UserRepository(localDataSource, remoteDataSource)

}
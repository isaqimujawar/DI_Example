package com.example.diexample.login.model

import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val loginService: ILoginService
) : IUserRemoteDataSource {

}
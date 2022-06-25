package com.example.diexample.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.diexample.login.model.IUserRepository
import com.example.diexample.login.model.UserRepository

class LoginViewModel() : ViewModel() {
    fun setUserRepository(userRepository: IUserRepository){

    }

    fun getGreetings() = "Hello User"

}
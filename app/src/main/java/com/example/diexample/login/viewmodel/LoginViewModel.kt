package com.example.diexample.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.diexample.login.model.IUserRepository
import com.example.diexample.login.model.UserRepository

class LoginViewModel() : ViewModel() {
    // We can use Field Injection (or Setter Injection) if we don't have access to the constructor of the class
    fun setUserRepository(userRepository: IUserRepository){

    }

    fun getGreetings() = "Hello User"

}
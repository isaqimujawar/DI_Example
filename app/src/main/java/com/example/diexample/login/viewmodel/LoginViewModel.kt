package com.example.diexample.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.diexample.login.model.IUserRepository


class LoginViewModel : ViewModel() {
    lateinit var myUserRepository: IUserRepository

    // We can use Field Injection (or Setter Injection) if we don't have access to the constructor of the class
    fun setUserRepository(userRepository: IUserRepository) {
        this.myUserRepository = userRepository
    }

    fun saveUser(name: String, email: String) {
        myUserRepository.saveUser(name, email)
    }

    fun getGreetings() = "Hello Hilt User"
}
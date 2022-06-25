package com.example.diexample.login.model

interface IUserRepository {
    fun saveUser(name: String, email: String)
}
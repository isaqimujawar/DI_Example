package com.example.diexample.login.model

import android.util.Log
import javax.inject.Inject

const val TAG = "HiltExample"

class UserRepository @Inject constructor(
    private val localDataSource: IUserLocalDataSource,
    private val remoteDataSource: IUserRemoteDataSource
) : IUserRepository {

    override fun saveUser(name: String, email: String) {
        Log.d(TAG, "saveUser: $name, email: $email")
    }
}
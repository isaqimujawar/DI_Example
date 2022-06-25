package com.example.diexample

import android.app.Application
import com.example.diexample.container.AppContainer

class MyApplication : Application() {

    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer()
}
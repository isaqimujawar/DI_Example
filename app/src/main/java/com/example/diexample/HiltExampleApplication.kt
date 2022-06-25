package com.example.diexample

import android.app.Application
import com.example.diexample.container.AppContainer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltExampleApplication : Application() {
    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer()
}
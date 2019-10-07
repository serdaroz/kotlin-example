package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.networkModule
import com.example.movieapp.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(uiModule, networkModule))
        }
    }


}
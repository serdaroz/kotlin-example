package com.example.movieapp

import android.app.Application
import com.example.movieapp.di.Inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG)
                androidLogger()
            androidContext(this@App)
            modules(Inject.modules)

        }
    }


}
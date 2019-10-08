package com.example.movieapp.ui.splash

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashPresenter :
    SplashContract.Presenter {

    override lateinit var view: SplashContract.View


    override fun splashCountDown() {
        GlobalScope.launch {
            delay(3000)
            view.startActivity()
        }
    }

    override fun onViewCreated() {
        splashCountDown()
    }

    override fun onResume() {
        //PASS
    }


    override fun onCreate() {
        //PASS
    }

}
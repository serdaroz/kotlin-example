package com.example.movieapp.ui.splash

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashPresenter(view: SplashContract.View) :
    SplashContract.Presenter {

    private var view: SplashContract.View? = view

    override fun splashCountDown() {
        GlobalScope.launch {
            delay(3000)
            view?.startActivity()
        }
    }

    override  fun onViewCreated() {
        splashCountDown()
    }

    override  fun onResume() {
        //PASS
    }

    override  fun onDestroy() {
        this.view = null
    }

    override  fun onCreate() {
        //PASS
    }

}
package com.example.movieapp.ui.splash

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView

interface SplashContract {

    interface Presenter : BasePresenter<View> {

        fun splashCountDown()

    }

    interface View : BaseView<Presenter> {

        fun startActivity()

    }

}
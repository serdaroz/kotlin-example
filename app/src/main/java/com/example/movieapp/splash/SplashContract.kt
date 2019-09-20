package com.example.movieapp.splash

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView

interface SplashContract {

    interface Presenter : BasePresenter {

        fun splashCountDown()

    }

    interface View : BaseView<Presenter> {

        fun startActivity()

    }

}
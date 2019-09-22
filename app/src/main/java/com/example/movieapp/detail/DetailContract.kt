package com.example.movieapp.detail

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView

interface DetailContract {


    interface Presenter : BasePresenter {

    }
    interface View : BaseView<Presenter> {

    }
}
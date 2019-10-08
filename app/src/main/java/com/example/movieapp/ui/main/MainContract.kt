package com.example.movieapp.ui.main

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView
import com.example.movieapp.model.Trending

interface MainContract {

    interface Presenter : BasePresenter<View> {

        suspend fun loadTrendList(page: Long)

    }

    interface View : BaseView<Presenter> {


        suspend fun displayTrendList(trending: Trending?)

    }

}
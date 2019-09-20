package com.example.movieapp.main

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView
import com.example.movieapp.model.Trending

interface MainContract {

    interface Presenter : BasePresenter {

        suspend fun loadTrendList(page: Long)

    }

    interface View : BaseView<Presenter> {

        fun onMovieClicked()

        suspend fun displayTrendList(trending: Trending?)

    }

}
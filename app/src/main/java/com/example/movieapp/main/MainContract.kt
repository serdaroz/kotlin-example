package com.example.movieapp.main

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView
import com.example.movieapp.model.Trending

interface MainContract {

    interface Presenter : BasePresenter {

        suspend fun loadTrendList(page: Long)

        fun settingsMenu()

    }

    interface View : BaseView<Presenter> {

        fun onSettingClicked()

        suspend fun displayTrendList(trending: Trending?)

    }

}
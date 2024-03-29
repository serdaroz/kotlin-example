package com.example.movieapp.ui.detail

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView
import com.example.movieapp.model.MovieDetail

interface DetailContract {

    interface Presenter : BasePresenter<View> {

        suspend fun requestMovieDetail()

    }

    interface View : BaseView<Presenter> {

        fun displayMovieDetail(movieDetail: MovieDetail?)

    }
}
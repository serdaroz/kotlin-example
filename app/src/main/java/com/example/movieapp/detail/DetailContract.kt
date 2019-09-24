package com.example.movieapp.detail

import com.example.movieapp.base.ui.BasePresenter
import com.example.movieapp.base.ui.BaseView
import com.example.movieapp.model.MovieDetail

interface DetailContract {

    interface Presenter : BasePresenter {

        suspend fun requestMovieDetail()

    }

    interface View : BaseView<Presenter> {

        fun displayMovieDetail(movieDetail: MovieDetail?)

    }
}
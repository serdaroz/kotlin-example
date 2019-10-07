package com.example.movieapp.ui.detail

import com.example.movieapp.di.DependencyInjector
import com.example.movieapp.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailPresenter(
    view: DetailContract.View,
    dependencyInjector: DependencyInjector,
    private val imdbId: Int
) :
    DetailContract.Presenter {


    private val movieDetailRepository: MovieDetailRepository =
        dependencyInjector.movieDetailRepository()


    private var view: DetailContract.View? = view

    override fun onCreate() {
    }

    override fun onViewCreated() {
        GlobalScope.launch {
            requestMovieDetail()
        }
    }

    override fun onResume() {
    }

    override fun onDestroy() {
        this.view = null
    }

    override suspend fun requestMovieDetail() {
        CoroutineScope(IO).launch {
            val movieDetail = movieDetailRepository.loadMovieDetail(imdbId)
            displayMovieDetail(movieDetail)
        }
    }

    private fun displayMovieDetail(movieDetail: MovieDetail?) {
        CoroutineScope(Main).launch {
            view!!.displayMovieDetail(movieDetail)
        }
    }

}
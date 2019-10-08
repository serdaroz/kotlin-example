package com.example.movieapp.ui.detail

import com.example.movieapp.base.BaseCoroutine
import com.example.movieapp.data.RepositoryInjector
import com.example.movieapp.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailPresenter(
    dependencyInjector: RepositoryInjector,
    private val imdbId: Int
) :
    DetailContract.Presenter, BaseCoroutine() {


    private val movieDetailRepository: MovieDetailRepository =
        dependencyInjector.movieDetailRepository()


    override lateinit var view: DetailContract.View


    override fun onCreate() {
    }

    override fun onViewCreated() {
        GlobalScope.launch {
            requestMovieDetail()
        }
    }

    override fun onResume() {
    }

    override suspend fun requestMovieDetail() {
        uiScope.launch {
            val movieDetail =
                withContext(bgDispatcher) { movieDetailRepository.loadMovieDetail(imdbId) }
            view.displayMovieDetail(movieDetail)
        }
    }


}
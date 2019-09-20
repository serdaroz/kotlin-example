package com.example.movieapp.main

import com.example.movieapp.di.DependencyInjector
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenter(
    view: MainContract.View,
    dependencyInjector: DependencyInjector
) : MainContract.Presenter {

    private val trendListRepository: TrendListRepository = dependencyInjector.trendListRepository()

    private var view: MainContract.View? = view

    override suspend fun loadTrendList(page: Long) {
        val trendList = trendListRepository.loadTrendList(page)
        view?.displayTrendList(trendList)
    }

    override fun onViewCreated() {
        GlobalScope.launch {
            loadTrendList(0)
        }
    }

    override fun onCreate() {
    }

    override fun onResume() {
    }


    override fun onDestroy() {
        this.view = null
    }


}
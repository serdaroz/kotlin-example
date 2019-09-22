package com.example.movieapp.main

import com.example.movieapp.di.DependencyInjector
import com.example.movieapp.model.Trending
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    view: MainContract.View,
    dependencyInjector: DependencyInjector
) : MainContract.Presenter {

    private val trendListRepository: TrendListRepository = dependencyInjector.trendListRepository()

    private var view: MainContract.View? = view

    override suspend fun loadTrendList(page: Long) {
        CoroutineScope(IO).launch {
            val trendList = trendListRepository.loadTrendList(page)
            displayTrendList(trendList)
        }
    }

    private suspend fun displayTrendList(trendList: Trending?) {
        CoroutineScope(Main).launch {
            view!!.displayTrendList(trendList)
        }
    }

    override fun onViewCreated() {
        GlobalScope.launch {
            loadTrendList(1)
        }
    }

    override fun onCreate() {
    }

    override fun onResume() {
    }


    override fun onDestroy() {
        this.view = null
    }

    override fun settingsMenu() {

    }


}
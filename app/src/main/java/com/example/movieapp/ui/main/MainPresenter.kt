package com.example.movieapp.ui.main

import android.content.Context
import com.example.movieapp.base.BaseCoroutine
import com.example.movieapp.data.RepositoryInjector
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    dependencyInjector: RepositoryInjector,
    context: Context
) : MainContract.Presenter, BaseCoroutine() {

    override lateinit var view: MainContract.View

    private val trendListRepository: TrendListRepository = dependencyInjector.trendListRepository()

    override suspend fun loadTrendList(page: Long) {
        uiScope.launch {
            val trendList = withContext(bgDispatcher) { trendListRepository.loadTrendList(page) }
            view.displayTrendList(trendList)
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


}
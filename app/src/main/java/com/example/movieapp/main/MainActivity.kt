package com.example.movieapp.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.di.DependencyInjectorImpl
import com.example.movieapp.model.TrendDetail
import com.example.movieapp.model.Trending
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class MainActivity : BaseActivity(), MainContract.View,
    TrendListAdapter.TrendListItemClickListener {

    internal lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPresenter(MainPresenter(this, DependencyInjectorImpl()))
        GlobalScope.launch {
            presenter.onViewCreated()
        }
        trendListRecycler.layoutManager = GridLayoutManager(this, 2)
    }

    override suspend fun displayTrendList(trending: Trending?) {
        trendListRecycler.adapter = TrendListAdapter(trending!!.mTrendDetails, this.get())
    }

    override fun onItemClicked(item: TrendDetail) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
    }

    override fun onMovieClicked() {
//
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }


    override fun onDestroy() {
        GlobalScope.launch {
            presenter.onDestroy()
        }
        super.onDestroy()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}

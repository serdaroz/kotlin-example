package com.example.movieapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R.layout
import com.example.movieapp.R.string
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.ui.detail.DetailActivity
import com.example.movieapp.di.DependencyInjectorImpl
import com.example.movieapp.model.Trending
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), MainContract.View {

    internal lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setPresenter(MainPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()
        trendListRecycler.layoutManager = GridLayoutManager(this, 2)
        floatingSettingButton.setOnClickListener {
            onSettingClicked()
        }
    }

    override fun onSettingClicked() {
        presenter.settingsMenu()
    }

    override suspend fun displayTrendList(trending: Trending?) {
        trendListRecycler.visibility = View.VISIBLE
        lottieLoadingAnimation.visibility = View.GONE
        trendListRecycler.adapter =
            TrendListAdapter(
                trending!!.trendDetails!!,
                trendListItemClickListener = object :
                    TrendListAdapter.TrendListItemClickListener {
                    override fun onItemClicked(imdbId: Int?, view: View) {
                        val transitionName = resources.getString(string.movie_poster)
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this@MainActivity,
                            view,
                            transitionName
                        )
                        startActivity(
                            DetailActivity.onNewIntent(
                                this@MainActivity,
                                imdbId
                            ),
                            options.toBundle()
                        )
                    }
                })
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        fun onNewIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}

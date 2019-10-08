package com.example.movieapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.R.layout
import com.example.movieapp.R.string
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.model.Trending
import com.example.movieapp.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject


class MainActivity : BaseActivity(), MainContract.View {

    override val presenter by inject<MainContract.Presenter>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        presenter.view = this
        presenter.onViewCreated()
        trendListRecycler.layoutManager = GridLayoutManager(this, 2)
        lottieLoadingAnimation.playAnimation()
    }


    override suspend fun displayTrendList(trending: Trending?) {
        trendListRecycler.visibility = View.VISIBLE
        lottieLoadingAnimation.visibility = View.GONE
        trendListRecycler.adapter =
            TrendListAdapter(
                trending!!.trendDetails!!,
                trendListItemClickListener = object : TrendListAdapter.TrendListItemClickListener {
                    override fun onItemClicked(imdbId: Int?, view: View) {
                        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this@MainActivity,
                            view as ImageView,
                            getString(string.movie_poster)
                        )
                        startActivity(
                            DetailActivity.onNewIntent(
                                this@MainActivity, imdbId
                            ),
                            options.toBundle()
                        )
                    }
                })
    }


    companion object {
        fun onNewIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}

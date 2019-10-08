package com.example.movieapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import coil.api.load
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.model.MovieDetail
import com.example.movieapp.util.Constants.PHOTO_URL
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject

class DetailActivity : BaseActivity(), DetailContract.View {

    override val presenter by inject<DetailContract.Presenter>()

    var imdbId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        imdbId = intent.getIntExtra(IMDB_ID, -1)
        getKoin().setProperty(IMDB_ID, imdbId)
        presenter.view = this
        presenter.onViewCreated()
    }

    override fun displayMovieDetail(movieDetail: MovieDetail?) {
        ivPoster.load(PHOTO_URL + movieDetail!!.backdropPath)
    }

    companion object {

        const val IMDB_ID = "imdbId"

        fun onNewIntent(context: Context, imdbId: Int?): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IMDB_ID, imdbId)
            return intent
        }
    }
}
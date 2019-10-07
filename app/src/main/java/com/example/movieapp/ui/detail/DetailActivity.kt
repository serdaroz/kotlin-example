package com.example.movieapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import coil.api.load
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.di.DependencyInjectorImpl
import com.example.movieapp.model.MovieDetail
import com.example.movieapp.util.Constants.PHOTO_URL
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(), DetailContract.View {

    internal lateinit var presenter: DetailContract.Presenter

    var imdbId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        imdbId = intent.getIntExtra(IMDB_ID, -1)
        setPresenter(
            DetailPresenter(
                this,
                DependencyInjectorImpl(),
                imdbId
            )
        )
        presenter.onViewCreated()
    }

    override fun setPresenter(presenter: DetailContract.Presenter) {
        this.presenter = presenter
    }


    override fun displayMovieDetail(movieDetail: MovieDetail?) {
        toolbar_cover_image.load(PHOTO_URL + movieDetail!!.backdropPath)
    }

    companion object {

        private const val IMDB_ID = "imdbId"

        fun onNewIntent(context: Context, imdbId: Int?): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(IMDB_ID, imdbId)
            return intent
        }
    }
}
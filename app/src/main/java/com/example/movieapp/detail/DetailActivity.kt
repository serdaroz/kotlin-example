package com.example.movieapp.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity

class DetailActivity : BaseActivity(), DetailContract.View {

    internal lateinit var presenter: DetailContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setPresenter(DetailPresenter(this))
      //  toolbar_cover_image.load(this,  )
    }

    override fun setPresenter(presenter: DetailContract.Presenter) {
        this.presenter = presenter
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
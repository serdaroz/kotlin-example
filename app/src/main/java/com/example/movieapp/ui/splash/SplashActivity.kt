package com.example.movieapp.ui.splash

import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.ui.main.MainActivity

class SplashActivity : BaseActivity(), SplashContract.View {

    internal lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setPresenter(SplashPresenter(this))
        presenter.onViewCreated()

    }

    override fun startActivity() {
        openActivity(
            MainActivity.onNewIntent(this),
            R.anim.slide_in_left, R.anim.slide_out_left
        )
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        this.presenter = presenter
    }


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
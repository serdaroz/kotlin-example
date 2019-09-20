package com.example.movieapp.splash

import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.di.DependencyInjectorImpl
import com.example.movieapp.main.MainActivity
import com.example.movieapp.main.MainPresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SplashActivity : BaseActivity(), SplashContract.View {

    internal lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setPresenter(SplashPresenter(this))
        GlobalScope.launch {
            presenter.onViewCreated()
        }

    }

    override fun startActivity() {
        openActivity(
            MainActivity.newIntent(this),
            R.anim.slide_in_left, R.anim.slide_out_left
        )
    }

    override fun setPresenter(presenter: SplashContract.Presenter) {
        this.presenter = presenter
    }


    override fun onDestroy() {
        GlobalScope.launch {
            presenter.onDestroy()
        }
        super.onDestroy()
    }
}
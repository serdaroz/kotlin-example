package com.example.movieapp.ui.splash

import android.os.Bundle
import com.example.movieapp.R
import com.example.movieapp.base.ui.BaseActivity
import com.example.movieapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject

class SplashActivity : BaseActivity(), SplashContract.View {

    override val presenter by inject<SplashContract.Presenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter.view = this
        presenter.onViewCreated()
        splashAnimationLottie.playAnimation()
    }

    override fun startActivity() {
        openActivity(
            MainActivity.onNewIntent(this),
            R.anim.slide_in_left, R.anim.slide_out_left
        )
    }
}
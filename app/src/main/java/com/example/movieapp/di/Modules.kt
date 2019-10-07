package com.example.movieapp.di

import android.content.Context
import com.example.movieapp.data.RepositoryInjectorImpl
import com.example.movieapp.network.RetrofitServicesAPI
import com.example.movieapp.ui.detail.DetailActivity
import com.example.movieapp.ui.detail.DetailActivity.Companion.IMDB_ID
import com.example.movieapp.ui.detail.DetailContract
import com.example.movieapp.ui.detail.DetailPresenter
import com.example.movieapp.ui.main.MainActivity
import com.example.movieapp.ui.main.MainContract
import com.example.movieapp.ui.main.MainPresenter
import com.example.movieapp.ui.splash.SplashActivity
import com.example.movieapp.ui.splash.SplashContract
import com.example.movieapp.ui.splash.SplashPresenter
import org.koin.dsl.module

val networkModule = module {

    single { RetrofitServicesAPI.invoke() }

}

val uiModule = module {

    factory { MainActivity() }
    factory {
        MainPresenter(
            RepositoryInjectorImpl(),
            get() as Context
        ) as MainContract.Presenter
    }

    factory { DetailActivity() }
    factory {
        DetailPresenter(
            RepositoryInjectorImpl(),
            getProperty(IMDB_ID)
        ) as DetailContract.Presenter
    }

    factory { SplashActivity() }
    factory { SplashPresenter() as SplashContract.Presenter }
}



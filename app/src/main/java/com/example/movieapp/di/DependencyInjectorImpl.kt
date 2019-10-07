package com.example.movieapp.di

import com.example.movieapp.ui.detail.MovieDetailRepository
import com.example.movieapp.ui.detail.MovieDetailRepositoryImpl
import com.example.movieapp.ui.main.TrendListRepository
import com.example.movieapp.ui.main.TrendListRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {

    override fun movieDetailRepository(): MovieDetailRepository {
        return MovieDetailRepositoryImpl()
    }

    override fun trendListRepository(): TrendListRepository {
        return TrendListRepositoryImpl()
    }

}
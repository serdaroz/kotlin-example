package com.example.movieapp.di

import com.example.movieapp.detail.MovieDetailRepository
import com.example.movieapp.detail.MovieDetailRepositoryImpl
import com.example.movieapp.main.TrendListRepository
import com.example.movieapp.main.TrendListRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {

    override fun movieDetailRepository(): MovieDetailRepository {
        return MovieDetailRepositoryImpl()
    }

    override fun trendListRepository(): TrendListRepository {
        return TrendListRepositoryImpl()
    }

}
package com.example.movieapp.di

import com.example.movieapp.main.TrendListRepository
import com.example.movieapp.main.TrendListRepositoryImpl

class DependencyInjectorImpl : DependencyInjector {
    override fun trendListRepository(): TrendListRepository {
       return TrendListRepositoryImpl()
    }

}
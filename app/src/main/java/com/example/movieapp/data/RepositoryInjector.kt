package com.example.movieapp.data

import com.example.movieapp.ui.detail.MovieDetailRepository
import com.example.movieapp.ui.main.TrendListRepository

interface RepositoryInjector {

    fun trendListRepository() : TrendListRepository

    fun movieDetailRepository() : MovieDetailRepository
}
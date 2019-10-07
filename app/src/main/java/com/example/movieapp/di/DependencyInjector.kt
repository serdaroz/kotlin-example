package com.example.movieapp.di

import com.example.movieapp.ui.detail.MovieDetailRepository
import com.example.movieapp.ui.main.TrendListRepository

interface DependencyInjector {

    fun trendListRepository() : TrendListRepository

    fun movieDetailRepository() : MovieDetailRepository
}
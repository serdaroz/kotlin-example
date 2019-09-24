package com.example.movieapp.di

import com.example.movieapp.detail.MovieDetailRepository
import com.example.movieapp.main.TrendListRepository

interface DependencyInjector {

    fun trendListRepository() : TrendListRepository

    fun movieDetailRepository() : MovieDetailRepository
}
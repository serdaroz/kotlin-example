package com.example.movieapp.di

import com.example.movieapp.main.TrendListRepository

interface DependencyInjector {

    fun trendListRepository() : TrendListRepository
}
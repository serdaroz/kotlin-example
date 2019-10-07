package com.example.movieapp.ui.main

import com.example.movieapp.model.Trending


interface TrendListRepository  {

    suspend fun loadTrendList(page: Long): Trending?

}
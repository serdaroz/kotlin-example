package com.example.movieapp.main

import com.example.movieapp.model.Trending


interface TrendListRepository  {

    suspend fun loadTrendList(page: Long): Trending?

}
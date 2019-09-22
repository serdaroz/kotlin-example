package com.example.movieapp.main

import com.example.movieapp.model.TrendTypes
import com.example.movieapp.model.Trending
import com.example.movieapp.network.RetrofitServicesAPI

class TrendListRepositoryImpl : TrendListRepository {

    private val service = RetrofitServicesAPI.invoke()

    override suspend fun loadTrendList(page: Long): Trending? {
        val trendList = service.getTrendListAsync(
            mediaType = TrendTypes.TrendCategoryTypes.ALL.name,
            timeWindow = TrendTypes.TrendDayTypes.WEEK.name,
            page = page
        ).await()

        return trendList.body()
    }
}

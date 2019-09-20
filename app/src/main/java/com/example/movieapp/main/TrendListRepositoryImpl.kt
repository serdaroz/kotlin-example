package com.example.movieapp.main

import com.example.movieapp.network.RetrofitClient
import com.example.movieapp.model.TrendTypes
import com.example.movieapp.model.Trending
import com.example.movieapp.util.Constants.Companion.API_KEY

class TrendListRepositoryImpl : TrendListRepository {

    override suspend fun loadTrendList(page: Long): Trending? {
        val trendList = service.getTrendListAsync(
            mediaType = TrendTypes.TrendCategoryTypes.ALL.name,
            timeWindow = TrendTypes.TrendDayTypes.WEEK.name,
            apiKey = API_KEY,
            page = page
        ).await()

        return trendList.body()

    }

    private val service = RetrofitClient.makeRetrofitService()



}

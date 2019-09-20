package com.example.movieapp.network

import com.example.movieapp.model.Trending
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServicesAPI {

    @GET("3/trending/{media_type}/{time_window}")
    fun getTrendListAsync(@Path("media_type") mediaType : String, @Path("time_window")
    timeWindow : String, @Query("api_key") apiKey : String, @Query("page")  page : Long) : Deferred<Response<Trending>>

}
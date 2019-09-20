package com.example.movieapp.network

import com.example.movieapp.util.Constants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class RetrofitClient {

    companion object {

        fun makeRetrofitService(): RetrofitServicesAPI {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(RetrofitServicesAPI::class.java)
        }
    }


}
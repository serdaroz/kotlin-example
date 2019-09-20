package com.example.movieapp.network

interface BaseRetrofitCallBack<T> {

   suspend fun onSuccessful(data : T?)

   suspend fun onFailure(message : Throwable)
}
package com.example.movieapp.base

import com.example.movieapp.network.BaseRetrofitCallBack

abstract class BaseRepository<T> : BaseRetrofitCallBack<T> {


    override suspend fun onFailure(message: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun onSuccessful(data: T?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
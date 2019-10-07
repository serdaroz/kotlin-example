package com.example.movieapp.ui.detail

import com.example.movieapp.model.MovieDetail
import com.example.movieapp.network.RetrofitServicesAPI


class MovieDetailRepositoryImpl : MovieDetailRepository {

    private val service = RetrofitServicesAPI.invoke()


    override suspend fun loadMovieDetail(imdbId: Int): MovieDetail? {

        return service.getMovieDetailAsync(
            imdbId
        ).await()
    }


}
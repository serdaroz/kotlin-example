package com.example.movieapp.detail

import com.example.movieapp.model.MovieDetail

interface MovieDetailRepository {

    suspend fun loadMovieDetail(imdbId: Int): MovieDetail?

}
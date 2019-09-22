package com.example.movieapp.network

import com.example.movieapp.model.Trending
import com.example.movieapp.util.Constants.Companion.API_KEY
import com.example.movieapp.util.Constants.Companion.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServicesAPI {

    @GET("3/trending/{media_type}/{time_window}")
    fun getTrendListAsync(
        @Path("media_type") mediaType: String,
        @Path("time_window") timeWindow: String,
        @Query("page") page: Long
    ): Deferred<Response<Trending>>


    //@GET("3/movie/{movie_id}")
    //fun getMovieDetail(@Path("movie_id")  movieId : Long) : Deferred<MovieDetail>

    companion object {
        operator fun invoke(): RetrofitServicesAPI {

            val requestInterceptor = Interceptor {
                val url = it
                    .request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()

                val request = it
                    .request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServicesAPI::class.java)
        }

    }
}
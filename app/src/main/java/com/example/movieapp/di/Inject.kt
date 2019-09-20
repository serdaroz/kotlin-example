package com.example.movieapp.di

import com.example.movieapp.network.RetrofitClient
import org.koin.dsl.module

object Inject {

    val modules = module {

        single { RetrofitClient }

    }




}
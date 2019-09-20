package com.example.movieapp.di

import com.example.movieapp.network.RetrofitServicesAPI
import org.koin.dsl.module

object Inject {

    val modules = module {

        single { RetrofitServicesAPI.invoke() }

    }


}
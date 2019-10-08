package com.example.movieapp.base.ui

interface BasePresenter<T> {

    var view: T

    fun onCreate()

    fun onViewCreated()

    fun onResume()


}
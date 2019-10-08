package com.example.movieapp.base.ui

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T

}
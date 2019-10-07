package com.example.movieapp.base.ui

interface BaseView<T : BasePresenter<*>> {

    val presenter: T
}
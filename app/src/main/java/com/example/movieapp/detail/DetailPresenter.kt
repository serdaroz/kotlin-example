package com.example.movieapp.detail

class DetailPresenter(view: DetailContract.View) : DetailContract.Presenter {

    private var view: DetailContract.View? = view

    override fun onCreate() {
    }

    override fun onViewCreated() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
        this.view = null
    }


}
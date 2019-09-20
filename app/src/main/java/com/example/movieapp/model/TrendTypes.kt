package com.example.movieapp.model


class TrendTypes {

    enum class TrendDayTypes(type: String) {
        WEEK("week"), DAY("day")
    }

    enum class TrendCategoryTypes(type : String) {
        ALL("all"), MOVIE("movie"), TV("tv"), PERSON("person")
    }

}
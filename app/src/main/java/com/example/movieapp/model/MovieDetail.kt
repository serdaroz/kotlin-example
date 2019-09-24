package com.example.movieapp.model


import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("adult")
    var adult: Boolean? = null,
    @SerializedName("backdrop_path")
    var backdropPath: Any? = null,
    @SerializedName("belongs_to_collection")
    var belongsToCollection: Any? = null,
    @SerializedName("budget")
    var budget: Int? = null,
    @SerializedName("genres")
    var genres: List<Genre?>? = null,
    @SerializedName("homepage")
    var homepage: Any? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("imdb_id")
    var imdbId: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @SerializedName("original_title")
    var originalTitle: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null,
    @SerializedName("production_companies")
    var productionCompanies: List<Any?>? = null,
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountry?>? = null,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("revenue")
    var revenue: Int? = null,
    @SerializedName("runtime")
    var runtime: Int? = null,
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage?>? = null,
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("video")
    var video: Boolean? = null,
    @SerializedName("vote_average")
    var voteAverage: Double? = null,
    @SerializedName("vote_count")
    var voteCount: Int? = null
)

data class SpokenLanguage(
    @SerializedName("iso_639_1")
    var iso6391: String? = null,
    @SerializedName("name")
    var name: String? = null
)

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    var iso31661: String? = null,
    @SerializedName("name")
    var name: String? = null
)

data class Genre(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null
)

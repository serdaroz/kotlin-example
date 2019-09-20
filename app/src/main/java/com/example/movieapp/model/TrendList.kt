package com.example.movieapp.model

import com.google.gson.annotations.SerializedName

data class Trending(
    @SerializedName("page")
    private val mPage: Long? = null,
    @SerializedName("results")
    public val mTrendDetails: List<TrendDetail>? = null,
    @SerializedName("total_pages")
    private val mTotalPages: Long? = null,
    @SerializedName("total_results")
    private val mTotalResults: Long? = null
)



data class TrendDetail(
    @SerializedName("adult")
    private val mAdult: Boolean? = null,
    @SerializedName("backdrop_path")
    private val mBackdropPath: String? = null,
    @SerializedName("genre_ids")
    private val mGenreIds: List<Long>? = null,
    @SerializedName("id")
    private val mId: Long? = null,
    @SerializedName("original_language")
    private val mOriginalLanguage: String? = null,
    @SerializedName("original_title")
    private val mOriginalTitle: String? = null,
    @SerializedName("overview")
    private val mOverview: String? = null,
    @SerializedName("popularity")
    private val mPopularity: Double? = null,
    @SerializedName("poster_path")
    private val mPosterPath: String? = null,
    @SerializedName("release_date")
    private val mReleaseDate: String? = null,
    @SerializedName("title")
    private val mTitle: String? = null,
    @SerializedName("video")
    private val mVideo: Boolean? = null,
    @SerializedName("vote_average")
    private val mVoteAverage: Double? = null,
    @SerializedName("vote_count")
    private val mVoteCount: Long? = null
)


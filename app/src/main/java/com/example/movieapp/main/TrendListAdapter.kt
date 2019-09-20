package com.example.movieapp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.movieapp.R
import com.example.movieapp.model.TrendDetail
import com.example.movieapp.util.Constants.Companion.PHOTO_URL
import kotlinx.android.synthetic.main.card_view_trend.view.*

class TrendListAdapter(
    private val trendList: List<TrendDetail>?,
    private val trendListItemClickListener: TrendListItemClickListener
) : RecyclerView.Adapter<TrendListAdapter.ViewHolder>() {

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        fun dataBind(data: TrendDetail) {
            itemView.cvTrend.setOnClickListener {
                trendListItemClickListener.onItemClicked(data)
            }
            itemView.tvTitle.text = data.title
            itemView.tvType.text = data.mediaType
            itemView.tvYear.text = data.releaseDate
            itemView.ivPoster.load(PHOTO_URL + data.posterPath) {
                crossfade(true)
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
                networkCachePolicy(CachePolicy.ENABLED)
                error(R.drawable.place_holder)
                placeholder(R.drawable.place_holder)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_trend, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(trendList!![position])
    }

    override fun getItemCount(): Int {
        return trendList!!.size
    }

    interface TrendListItemClickListener {
        fun onItemClicked(item: TrendDetail)
    }
}


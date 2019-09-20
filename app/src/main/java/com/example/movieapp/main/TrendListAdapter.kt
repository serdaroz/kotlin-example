package com.example.movieapp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.model.TrendDetail
import kotlinx.android.synthetic.main.card_view_trend.view.*

class TrendListAdapter(
    private val trendList: List<TrendDetail>?,
    private val trendListItemClickListener: TrendListItemClickListener
) : RecyclerView.Adapter<TrendListAdapter.ViewHolder>() {

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        fun dataBind(data: TrendDetail) {
            itemView.trendCard.setOnClickListener {
                trendListItemClickListener.onItemClicked(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view_trend, parent, false)
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

package com.example.movieapp.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.decode.DataSource
import coil.request.CachePolicy
import coil.request.Request
import com.example.movieapp.R
import com.example.movieapp.base.GenericAdapter
import com.example.movieapp.model.TrendDetail
import com.example.movieapp.util.Constants.Companion.PHOTO_URL
import kotlinx.android.synthetic.main.trend_list_item.view.*

class TrendListAdapter(
    trendList: List<TrendDetail>,
    private val trendListItemClickListener: TrendListItemClickListener
) : GenericAdapter<TrendDetail>(listItems = trendList) {

    override fun getLayoutId(position: Int, obj: TrendDetail): Int {
        return R.layout.trend_list_item
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(view, trendListItemClickListener)
    }

    class ViewHolder(
        itemView: View,
        private val trendListItemClickListener: TrendListItemClickListener
    ) : RecyclerView.ViewHolder(itemView), Binder<TrendDetail> {
        override fun bind(data: TrendDetail) {
            itemView.cvTrend.setOnClickListener {
                trendListItemClickListener.onItemClicked(data.id, itemView.ivPoster)
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
                listener(object : Request.Listener {
                    override fun onError(data: Any, throwable: Throwable) {
                        super.onError(data, throwable)
                        throwable.printStackTrace()
                        itemView.lottieLoadingAnimation.visibility = View.GONE
                    }

                    override fun onCancel(data: Any) {
                        super.onCancel(data)
                        itemView.lottieLoadingAnimation.visibility = View.GONE
                    }

                    override fun onSuccess(data: Any, source: DataSource) {
                        super.onSuccess(data, source)
                        itemView.lottieLoadingAnimation.visibility = View.GONE
                    }
                })
            }
        }

    }


    interface TrendListItemClickListener {
        fun onItemClicked(imdbId: Int?, view: View)
    }


}


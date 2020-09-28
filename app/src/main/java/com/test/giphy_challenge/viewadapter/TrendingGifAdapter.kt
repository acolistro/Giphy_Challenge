package com.test.giphy_challenge.viewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.giphy_challenge.R
import com.test.giphy_challenge.databinding.ViewholderTrendingGifBinding
import com.test.giphy_challenge.domain.GifTrending

class TrendingGifAdapter : RecyclerView.Adapter<TrendingGifViewHolder>() {
    var result: List<GifTrending> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingGifViewHolder {
        val withDataBinding: ViewholderTrendingGifBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            TrendingGifViewHolder.LAYOUT,
            parent,
            false
        )
        return TrendingGifViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: TrendingGifViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.result = result[position]
        }
    }

    override fun getItemCount() = result.size
}

class TrendingGifViewHolder(val viewDataBinding: ViewholderTrendingGifBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.viewholder_trending_gif
    }
}
package com.joseph.movie.app.ui.main.viewholder

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.Nullable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.joseph.movie.app.R
import com.joseph.movie.app.constant.Constants
import com.joseph.movie.app.data.database.movie.Movie
import com.joseph.movie.app.utils.GlideApp
import kotlinx.android.synthetic.main.item_poster.view.*

public class MovieViewHolder(parent: ViewGroup) :
    RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_poster, parent, false)) {
    private val item_poster_post = itemView.item_poster_post
    private val item_poster_title = itemView.item_poster_title
    private val progress: ProgressBar = itemView.progress
    private val context: Context

    init {
        context = parent.context
    }

    fun bind(movie: Movie) {
        item_poster_title!!.setText(movie.title)
        val url = Constants.BASE_POSTER_PATH + movie.poster_path
        GlideApp.with(context)
            .load(url).override(300, 300)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    @Nullable e: GlideException?, model: Any,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    progress.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>,
                    dataSource: com.bumptech.glide.load.DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    progress.visibility = View.GONE
                    return false
                }
            })
            .into(item_poster_post)
    }
}
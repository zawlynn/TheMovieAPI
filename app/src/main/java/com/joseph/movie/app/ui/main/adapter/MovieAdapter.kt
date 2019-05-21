package com.joseph.movie.app.ui.main.adapter

import android.support.annotation.NonNull
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.joseph.movie.app.R
import com.joseph.movie.app.data.database.movie.Movie
import com.joseph.movie.app.ui.main.viewholder.MovieViewHolder

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieItemCallback()) {
    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): MovieViewHolder {
        return MovieViewHolder(parent)
    }

    override fun onBindViewHolder(@NonNull holder: MovieViewHolder, i: Int) {
        holder.bind(getItem(i))
    }

}

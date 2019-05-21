package com.joseph.movie.app.ui.main.adapter;


import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import com.joseph.movie.app.data.database.movie.Movie;

public class MovieItemCallback extends  DiffUtil.ItemCallback<Movie>{
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.equals(newItem);
    }
}

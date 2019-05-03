package com.joseph.movie.app.data.network

import com.google.gson.annotations.SerializedName
import com.joseph.movie.app.data.database.movie.Movie

data class ApiResponse(
    @SerializedName("results")
    val results:List<Movie>,
    @SerializedName("total_pages")
    val total_pages:Int
)
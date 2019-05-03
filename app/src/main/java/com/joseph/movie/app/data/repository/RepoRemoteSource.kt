package com.joseph.movie.app.data.repository


import android.util.Log
import com.joseph.movie.app.constant.Constants

import com.joseph.movie.app.data.network.ApiClient
import com.joseph.movie.app.data.network.ApiResponse
import com.joseph.movie.app.data.network.MovieService
import io.reactivex.Flowable
import retrofit2.Response


object RepoRemoteSource  {
    fun fetchRepos(): Flowable<Response<ApiResponse>>{
        Log.d("MOVIE REPOSITORY","fetchRepos")
        return ApiClient().create(Constants.BASE_URL,true).create(MovieService::class.java).getNowShowingMovies(Constants.API_KEY)
    }

}
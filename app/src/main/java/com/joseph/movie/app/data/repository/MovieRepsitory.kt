package com.joseph.movie.app.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.joseph.movie.app.constant.Constants
import com.joseph.movie.app.data.network.response.ApiResponse
import com.joseph.movie.app.data.network.NetworkBoundResource
import com.joseph.movie.app.data.database.movie.Movie
import com.joseph.movie.app.data.database.movie.MovieDAO
import com.joseph.movie.app.data.network.MovieService
import com.joseph.movie.app.data.network.Resource

import io.reactivex.Flowable

import retrofit2.Response


class MovieRepsitory(val repoRemoteSource: MovieService, val repoLocalSource: MovieDAO) {

    @SuppressLint("CheckResult")
    fun getArticles(context:Context) : Flowable<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, ApiResponse>(context) {

            override fun saveCallResult(request: ApiResponse) {
                   repoLocalSource.saveMovies(request.results)
            }

            override fun loadFromDb(): Flowable<List<Movie>> {
                Log.d("MOVIE REPOSITORY","LOAD FROM DB")
                return repoLocalSource.getAllMovies()
            }

            override fun createCall(): Flowable<Response<ApiResponse>> {
                Log.d("MOVIE REPOSITORY","CREATE CALL")
                return repoRemoteSource.getNowShowingMovies(Constants.API_KEY)
            }

        }.asFlowable()

    }

    fun getMovies(response: ApiResponse): List<Movie> {
        Log.d("RETROFIT", "WENT TO GET MOVIES "+response.results.size)
        return response.results
    }

}
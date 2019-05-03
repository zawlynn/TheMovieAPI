package com.joseph.movie.app.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.joseph.movie.app.data.network.ApiResponse
import com.joseph.movie.app.data.network.NetworkBoundResource
import com.joseph.movie.app.data.database.movie.Movie

import io.reactivex.Flowable

import retrofit2.Response


class MovieRepsitory(val repoRemoteSource: RepoRemoteSource, val repoLocalSource: RepoLocalSource) {

    @SuppressLint("CheckResult")
    fun getArticles(context:Context) : Flowable<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, ApiResponse>(context) {

            override fun saveCallResult(request: ApiResponse) {
                   repoLocalSource.saveMovies(request.results)
            }

            override fun loadFromDb(): Flowable<List<Movie>> {
                Log.d("MOVIE REPOSITORY","LOAD FROM DB")
                return repoLocalSource.fetchLocalMovie()
            }

            override fun createCall(): Flowable<Response<ApiResponse>> {
                Log.d("MOVIE REPOSITORY","CREATE CALL")
                return repoRemoteSource.fetchRepos()
            }

        }.asFlowable()

    }

    fun getMovies(response: ApiResponse): List<Movie> {
        Log.d("RETROFIT", "WENT TO GET MOVIES "+response.results.size)
        return response.results
    }

}
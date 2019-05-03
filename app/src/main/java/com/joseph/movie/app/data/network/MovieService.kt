package com.joseph.movie.app.data.network


import io.reactivex.Flowable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/now_playing")
    fun getNowShowingMovies(@Query("api_key") api_key:String): Flowable<Response<ApiResponse>>
}
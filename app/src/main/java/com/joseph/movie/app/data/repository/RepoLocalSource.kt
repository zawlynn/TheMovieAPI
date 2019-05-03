package com.joseph.movie.app.data.repository


import com.joseph.movie.app.MovieApplication
import com.joseph.movie.app.data.database.MovieDatabase
import com.joseph.movie.app.data.database.movie.Movie
import io.reactivex.Flowable

class RepoLocalSource(val application: MovieApplication)  {
    fun saveMovies(repos: List<Movie>) {
        MovieDatabase.getInstance(application).movieDao().saveMovies(repos)
    }

    fun fetchLocalMovie(): Flowable<List<Movie>> {
           return MovieDatabase.getInstance(application).movieDao().getAllMovies()
    }

}
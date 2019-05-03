package com.joseph.movie.app.data.database.movie

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable

@Dao
abstract class MovieDAO {
    @Insert
    abstract fun saveMovie(movie:Movie)
    @Query(" SELECT * FROM movies")
    abstract fun getAllMovies(): Flowable<List<Movie>>
    @Insert
    abstract fun saveMovies(movies:List<Movie>)
}
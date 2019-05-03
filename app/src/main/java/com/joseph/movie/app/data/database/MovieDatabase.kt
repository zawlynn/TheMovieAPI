package com.joseph.movie.app.data.database

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.joseph.movie.app.data.database.movie.Movie
import com.joseph.movie.app.data.database.movie.MovieDAO


@Database(entities = [Movie::class], version = 2, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
    companion object {
        var instant :MovieDatabase?=null
        fun getInstance(context: Application):MovieDatabase{
            if(instant==null){
                instant = Room.databaseBuilder(context,MovieDatabase::class.java,"movie.db").fallbackToDestructiveMigration().build()
            }
            return instant as MovieDatabase
        }
    }
}
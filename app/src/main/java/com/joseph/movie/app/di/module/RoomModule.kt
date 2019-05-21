package com.joseph.movie.app.di.module

import android.arch.persistence.room.Room
import com.joseph.movie.app.MovieApplication
import com.joseph.movie.app.data.database.MovieDatabase
import com.joseph.movie.app.data.database.movie.MovieDAO
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provoideMovieDao(database: MovieDatabase):MovieDAO{
        return database.movieDao()
    }

    @Provides
    fun provideDatabase(application: MovieApplication):MovieDatabase{
        return Room.databaseBuilder(application,MovieDatabase::class.java,"movie.db").fallbackToDestructiveMigration().build()
    }
}
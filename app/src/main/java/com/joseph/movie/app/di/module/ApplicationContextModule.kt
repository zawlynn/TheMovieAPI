package com.joseph.movie.app.di.module

import com.joseph.movie.app.MovieApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationContextModule(movieApplication: MovieApplication) {
    val applicaiton:MovieApplication
    init {
        this.applicaiton= movieApplication
    }
    @Provides
    @Singleton
    fun provideApplicatioln():MovieApplication{
        return applicaiton
    }
}
package com.joseph.movie.app.ui.main.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.joseph.movie.app.MovieApplication
import com.joseph.movie.app.data.database.movie.Movie
import com.joseph.movie.app.data.database.movie.MovieDAO
import com.joseph.movie.app.data.network.MovieService
import com.joseph.movie.app.data.network.Resource

import com.joseph.movie.app.data.repository.MovieRepsitory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var repository: MovieRepsitory
    val compositeDisposable = CompositeDisposable()
    var movies_live = MutableLiveData<List<Movie>>()
    @Inject
    lateinit var movieService:MovieService
    @Inject
    lateinit var movieDAO :MovieDAO
    init {
        MovieApplication.getInstance().component.inject(this)
        repository= MovieRepsitory(movieService,movieDAO);
    }


    fun fetchData(context: Context) {
        repository.getArticles(context)
            .subscribe {
                it.data?.let {
                    Log.d("MOVIE REPOSITORY", "GET DATA " + it.size)
                    movies_live.postValue(it)
                }
                if (it.status == Resource.Status.LOADING) {
                    Log.d("MOVIE REPOSITORY", "LOADING")
                } else if (it.status == Resource.Status.SUCCESS) {
                    Log.d("MOVIE REPOSITORY", "SUCCESS")
                } else if (it.status == Resource.Status.ERROR) {
                    Log.d("MOVIE REPOSITORY", "ERROR")
                }
            }.addTo(compositeDisposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movies_live
    }
}
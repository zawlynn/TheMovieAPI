package com.joseph.movie.app.ui.main.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.joseph.movie.app.data.database.movie.Movie

import com.joseph.movie.app.data.repository.RepoLocalSource
import com.joseph.movie.app.data.repository.RepoRemoteSource
import com.joseph.movie.app.data.repository.MovieRepsitory
import com.joseph.movie.app.data.repository.Resource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.OnErrorNotImplementedException

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    var localRepos: RepoLocalSource
    var repository: MovieRepsitory
    val compositeDisposable = CompositeDisposable()
    var movies_live = MutableLiveData<List<Movie>>()

    init {
        localRepos = RepoLocalSource(getApplication())
        repository = MovieRepsitory(RepoRemoteSource, localRepos)
    }

    @SuppressLint("CheckResult")
    fun fetchData(context: Context) {
        repository.getArticles(context)
            .subscribe {
                it.data?.let {
                    Log.d("MOVIE REPOSITORY","GET DATA "+it.size)
                    movies_live.postValue(it)
                }
                if(it.status==Resource.Status.LOADING){
                    Log.d("MOVIE REPOSITORY","LOADING")
                }else if(it.status==Resource.Status.SUCCESS){
                    Log.d("MOVIE REPOSITORY","SUCCESS")
                }else if(it.status==Resource.Status.ERROR){
                    Log.d("MOVIE REPOSITORY","ERROR")
                }


            }
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movies_live
    }
}
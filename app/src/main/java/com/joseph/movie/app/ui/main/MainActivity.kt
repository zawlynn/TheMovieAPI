package com.joseph.movie.app.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.joseph.movie.app.R
import com.joseph.movie.app.ui.main.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.fetchData(MainActivity@this)

        viewModel.getMovies().observe(this, Observer {
            if (!it.isNullOrEmpty()) {

            }
        })
    }

}

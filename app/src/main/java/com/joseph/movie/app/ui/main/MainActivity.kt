package com.joseph.movie.app.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.joseph.movie.app.R
import com.joseph.movie.app.ui.main.adapter.MovieAdapter
import com.joseph.movie.app.ui.main.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter:MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager=GridLayoutManager(applicationContext,2)
        adapter=MovieAdapter()
        recMovies.adapter=adapter
        recMovies.layoutManager=layoutManager
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.fetchData(applicationContext)

        viewModel.getMovies().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                adapter.submitList(it)
            }
        })
    }

}

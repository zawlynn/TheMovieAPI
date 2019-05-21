package com.joseph.movie.app.di.component

import com.joseph.movie.app.di.module.ApplicationContextModule
import com.joseph.movie.app.di.module.RetrofitModule
import com.joseph.movie.app.di.module.RoomModule
import com.joseph.movie.app.ui.main.viewmodel.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class,ApplicationContextModule::class,RoomModule::class])
interface DataComponent {
    fun inject(viewModel: MainActivityViewModel)
}
package com.joseph.movie.app;

import android.app.Application;
import com.joseph.movie.app.di.component.DaggerDataComponent;
import com.joseph.movie.app.di.component.DataComponent;
import com.joseph.movie.app.di.module.ApplicationContextModule;

public class MovieApplication extends Application {
    DataComponent component;
    static MovieApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        component=DaggerDataComponent.builder().applicationContextModule(new ApplicationContextModule(this)).build();
    }
    public DataComponent getComponent(){
        return component;
    }
    public static MovieApplication getInstance(){
        return instance;
    }
}

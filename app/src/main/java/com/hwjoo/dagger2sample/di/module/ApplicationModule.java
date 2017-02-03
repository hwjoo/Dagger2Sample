package com.hwjoo.dagger2sample.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;

import com.hwjoo.dagger2sample.di.ApplicationContext;
import com.hwjoo.dagger2sample.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hwjoo on 2017-02-02.
 */

@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }
    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication(){
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs(){
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

}

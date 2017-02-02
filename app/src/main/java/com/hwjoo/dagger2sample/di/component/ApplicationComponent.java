package com.hwjoo.dagger2sample.di.component;

import android.app.Application;
import android.content.Context;

import com.hwjoo.dagger2sample.DemoApplication;
import com.hwjoo.dagger2sample.data.DataManager;
import com.hwjoo.dagger2sample.data.DbHelper;
import com.hwjoo.dagger2sample.data.SharedPrefsHelper;
import com.hwjoo.dagger2sample.di.ApplicationContext;
import com.hwjoo.dagger2sample.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by hwjoo on 2017-02-02.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DemoApplication demoApplication);
    @ApplicationContext
    Context getContext();

    Application getApplication();
    DataManager getDataManager();
    SharedPrefsHelper getPreferenceHelper();
    DbHelper getDbHelper();
}

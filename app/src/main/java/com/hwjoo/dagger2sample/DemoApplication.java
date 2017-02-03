package com.hwjoo.dagger2sample;

import android.app.Application;
import android.content.Context;

import com.hwjoo.dagger2sample.data.DataManager;
import com.hwjoo.dagger2sample.di.component.ApplicationComponent;
import com.hwjoo.dagger2sample.di.component.DaggerApplicationComponent;
import com.hwjoo.dagger2sample.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by hwjoo on 2017-02-02.
 */

public class DemoApplication extends Application{
    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context){
        return (DemoApplication) context.getApplicationContext();
    }
    @Override
    public void onCreate(){
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }
    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
